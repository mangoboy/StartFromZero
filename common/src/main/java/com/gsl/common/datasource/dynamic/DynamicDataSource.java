package com.gsl.common.datasource.dynamic;

import com.gsl.common.datasource.holder.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源切换类
 * @author huangshuo
 * @created 2021/7/10
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // 获取当前数据源类型
        return DataSourceContextHolder.getDataSourceType();
    }
}
