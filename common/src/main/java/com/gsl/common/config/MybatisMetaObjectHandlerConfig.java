package com.gsl.common.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.gsl.common.context.UserInfoContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Optional;

/**
 * mybatisPlus设置填充规则
 *
 * @Author taojirun
 */
@Configuration
@EnableConfigurationProperties({MybatisPlusProperties.class})
@Slf4j
public class MybatisMetaObjectHandlerConfig {

    @Bean
    @ConditionalOnMissingBean
    public GlobalConfig globalConfig() {
        return (new GlobalConfig()).setMetaObjectHandler(this.vpMetaObjectHandler());
    }

//    private final static String DEBUGGER_USER_ID = "DEBUGGER_USER_ID";

    private static final String CREATE_TIME = "createTime";
    private static final String UPDATE_TIME = "updateTime";
    private static final String CREATE_BY = "createBy";
    private static final String UPDATE_BY = "updateBy";
    private static final String IS_DELETE = "isDelete";

    @Bean
    @ConditionalOnMissingBean
    public MetaObjectHandler vpMetaObjectHandler() {
        return new MetaObjectHandler() {
            //插入填充
            public void insertFill(MetaObject metaObject) {
                String userAccount = UserInfoContextHolder.getUserAccount();
                this.strictInsertFill(metaObject, IS_DELETE, Integer.class, 0);//逻辑删除
//                this.strictInsertFill(metaObject, VERSION, Integer.class, 1);//乐观锁机制
                if (StringUtils.isNotBlank(userAccount)) {
                    Object createBy = getFieldValByName(CREATE_BY, metaObject);
                    // 判断如果自定义有使用自定义
                    if (!Optional.ofNullable(createBy).isPresent()) {
                        createBy = userAccount;
                    }
                    this.setFieldValByName(CREATE_BY, createBy, metaObject);//创建人账号
                    this.setFieldValByName(UPDATE_BY, createBy, metaObject);//更新人账号
                }
                this.setFieldValByName(CREATE_TIME, new Date(), metaObject);
                this.setFieldValByName(UPDATE_TIME, new Date(), metaObject);
            }

            // 更新时的填充
            public void updateFill(MetaObject metaObject) {
                String userAccount = UserInfoContextHolder.getUserAccount();
                this.setFieldValByName(UPDATE_BY, userAccount, metaObject);//更新人
                this.setFieldValByName(UPDATE_TIME, new Date(), metaObject);
            }
        };
    }

}

