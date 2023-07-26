package com.gsl.common.datasource.i18n;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Invocation;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Locale;

/**
 * @author fandeshan
 * @description 数据库国际化处理
 * @date 2023/5/8
 */
@Slf4j
public class DataSourceI18nInterceptor implements InnerInterceptor {

    /**
     * i18n后缀
     **/
    private static final String I18N_SUFFIX = "_i18n";

    /**
     * 中文
     **/
    private static final String LANGUAGE_ZH = "zh";
    /**
     * 英文
     **/
    private static final String LANGUAGE_EN = "en";
    /**
     * 泰文
     **/
    private static final String LANGUAGE_TW = "tw";

    @Override
    public void beforePrepare(StatementHandler sh, Connection connection, Integer transactionTimeout) {
        PluginUtils.MPStatementHandler mpSh = PluginUtils.mpStatementHandler(sh);
        MappedStatement ms = mpSh.mappedStatement();
        SqlCommandType sct = ms.getSqlCommandType();
        BoundSql boundSql = sh.getBoundSql();
        String sql = boundSql.getSql().toLowerCase(Locale.ROOT);
        if (StringUtils.isBlank(sql) || !sql.contains(I18N_SUFFIX)) {
            return;
        }
        log.info("i18n拦截器， 处理sql前:{}", sql.replace("\n", ""));
        if (sct == SqlCommandType.INSERT || sct == SqlCommandType.UPDATE || sct == SqlCommandType.DELETE) {
            sql = handleSqlI18nDDL(sql);
        } else if (sct == SqlCommandType.SELECT) {
            sql = handleSqlI18nDQL(sql);
        }else {
            return;
        }
        try {
            //强制修改最终要执行的SQL
            setFieldValue(boundSql, "sql", sql);
            log.info("i18n拦截器， 处理sql后:{}", sql.replace("\n", ""));
        } catch (Exception e) {
            log.error("i18n interceptor modify sql error! ");
        }

    }

    /**
     * 用反射设置对象的属性值
     */
    private void setFieldValue(Object obj, String fieldName, Object fieldValue) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        ReflectionUtils.makeAccessible(field);
        field.set(obj, fieldValue);
    }


    /**
     * @param sql
     * @return java.lang.String
     * @description 处理i18n DDL
     * @author taojirun
     * @date 15:42 2023/5/10
     **/
    private String handleSqlI18nDDL(String sql) {
        return sql.replaceAll( I18N_SUFFIX, "");
    }

    /**
     * @param sql
     * @return java.lang.String
     * @description 处理i18n DQL
     * @author taojirun
     * @date 15:42 2023/5/10
     **/
    private String handleSqlI18nDQL(String sql) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RequestContext requestContext = new RequestContext(request);
        String language = requestContext.getLocale().getLanguage();
        if (StringUtils.isNotEmpty(language)) {
            if (language.contains(LANGUAGE_EN)) {
                return sql.replaceAll(I18N_SUFFIX, "_" +LANGUAGE_EN);
            } else if (language.contains(LANGUAGE_TW)) {
                return sql.replaceAll(I18N_SUFFIX, "_" +LANGUAGE_TW);
            }
        }
        //默认 删除 _i18n 字符
        return sql.replaceAll(I18N_SUFFIX, "");
    }


    public Object intercept(Invocation invocation) throws Throwable {

        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        BoundSql boundSql;
        //由于逻辑关系，只会进入一次
        if (args.length == 4) {
            //4 个参数时
            boundSql = ms.getBoundSql(parameter);
        } else {
            boundSql = (BoundSql) args[5];
        }
//        if (invocation.getTarget() instanceof Proxy){
//
//            Plugin plugin = (Plugin) Proxy.getInvocationHandler(invocation.getTarget());
//
//        }
//        else if (!(invocation.getTarget() instanceof RoutingStatementHandler)) {
//            return invocation.proceed();
//        }
//        RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
//        BoundSql boundSql = statementHandler.getBoundSql();

        String sql = handleSqlI18nDQL(boundSql.getSql());

        //强制修改最终要执行的SQL
        setFieldValue(boundSql, "sql", sql);
        return invocation.proceed();
    }

}
