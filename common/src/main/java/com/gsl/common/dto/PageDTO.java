package com.gsl.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description 分页参数
 * @author taojirun
 * @create 2023/5/16 16:53
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "pageNum", value = "页码(默认1)")
    private Integer pageNum = 1;

    @ApiModelProperty(name = "pageSize", value = "每页显示记录数(默认10)")
    private Integer pageSize = 10;
}