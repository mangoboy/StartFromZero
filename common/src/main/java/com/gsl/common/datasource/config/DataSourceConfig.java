package com.gsl.common.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.gsl.common.datasource.dynamic.DynamicDataSource;
import com.gsl.common.datasource.vo.DataSourceVO;
import com.gsl.common.datasource.vo.DynamicDataSourceVO;
import com.gsl.common.utils.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class DataSourceConfig {

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;

    @Bean
    @ConfigurationProperties(prefix = "dynamic")
    public DynamicDataSourceVO DynamicDataSourceVO() {
        return new DynamicDataSourceVO();
    }

    @Bean
    @Primary
    public DataSource dynamicDataSource(DynamicDataSourceVO dynamicDataSource) {

        Map<String, DataSourceVO> DataSourceVOMap = dynamicDataSource.getDataSourceMap();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        DynamicDataSource dds = new DynamicDataSource();
        for (String key : DataSourceVOMap.keySet()) {
            DataSourceVO dataSource = DataSourceVOMap.get(key);
            DruidDataSource druidDataSource = new DruidDataSource();
            try {
                druidDataSource.setDriverClassName(dataSource.getDriverClassName());
                druidDataSource.setUrl(dataSource.getUrl());
                druidDataSource.setUsername(dataSource.getUsername());
                druidDataSource.setPassword(AESUtil.decrypt(dataSource.getPassword()));
                druidDataSource.setInitialSize(dataSource.getInitialSize());
                druidDataSource.setMinIdle(dataSource.getMinIdle());
                druidDataSource.setMaxActive(dataSource.getMaxActive());
                druidDataSource.setTimeBetweenEvictionRunsMillis(dataSource.getTimeBetweenEvictionRunsMillis());
                druidDataSource.setMinEvictableIdleTimeMillis(dataSource.getMinEvictableIdleTimeMillis());
                druidDataSource.setValidationQuery(dataSource.getValidationQuery());
                druidDataSource.setTestWhileIdle(dataSource.getTestWhileIdle());
                druidDataSource.setTestOnBorrow(dataSource.getTestOnBorrow());
                druidDataSource.setTestOnReturn(dataSource.getTestOnReturn());
                druidDataSource.setDefaultAutoCommit(true);
                druidDataSource.setFilters(dataSource.getFilters());
            } catch (Exception e) {
                log.error("【Datasource设置】datasource [{}] 初始化失败！", key, e);
            }
            druidDataSource.setConnectionProperties(dataSource.getConnectionProperties());
            dataSourceMap.put(key, druidDataSource);
            if(dynamicDataSource.getDefaultDataSource().equals(key)) {
                dds.setDefaultTargetDataSource(druidDataSource);
            }
        }
        dds.setTargetDataSources(dataSourceMap);
        return dds;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DynamicDataSourceVO DynamicDataSourceVO) {
        return new DataSourceTransactionManager(this.dynamicDataSource(DynamicDataSourceVO));
    }
}
