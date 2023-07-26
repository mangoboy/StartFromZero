package com.gsl.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体基类
 *
 * @author system
 * @since 2023-04-28 09:55:34
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseDTO extends PageDTO{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "主键")
    private String id;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
