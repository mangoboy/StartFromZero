package com.gsl.video.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.gsl.common.config.MybatisMetaObjectHandlerConfig;
import com.gsl.common.config.RequestHeaderConfig;
import com.gsl.common.datasource.config.DataSourceConfig;
import com.gsl.common.datasource.i18n.DataSourceI18nInterceptor;
import com.gsl.common.interceptor.ControllerExceptionHandler;
import com.gsl.common.result.ResponseResultAutoConfiguration;
import com.gsl.common.utils.HttpUtil;
import com.gsl.common.utils.RedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author taojirun
 * @description 视频服务公共配置类
 * @date 2023/5/8
 */
@Configuration
@Import({ControllerExceptionHandler.class, ResponseResultAutoConfiguration.class, DataSourceConfig.class,
        RequestHeaderConfig.class, MybatisMetaObjectHandlerConfig.class, RedisUtil.class, HttpUtil.class})
public class VideoCommonConfig {

    //将插件加入到mybatis插件拦截链中
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加自定义拦截器
        interceptor.addInnerInterceptor(new DataSourceI18nInterceptor());
        return interceptor;
    }
}
