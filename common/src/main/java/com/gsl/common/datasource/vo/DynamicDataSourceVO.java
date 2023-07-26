package com.gsl.common.datasource.vo;

import lombok.Data;

import java.util.Map;

/**
 * @author huangshuo
 * @created 2021/10/5
 **/
@Data
public class DynamicDataSourceVO {

    /** 默认数据源 **/
    private String defaultDataSource;

    /** 数据源Map对象 **/
    private Map<String, DataSourceVO> dataSourceMap;

    public DynamicDataSourceVO() {}
}
