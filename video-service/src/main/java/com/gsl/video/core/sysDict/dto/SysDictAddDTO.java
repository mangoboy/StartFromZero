package com.gsl.video.core.sysDict.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统字典 AddDTO类
 * @author taojirun
 * @date 2023-05-23 14:16:50
 */
@Data
@ApiModel(value = "系统字典 AddDTO类")
public class SysDictAddDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	@ApiModelProperty(name = "label",value = "标签")
	private String label;

	@ApiModelProperty(name = "value",value = "标签值")
	private String value;

	@ApiModelProperty(name = "type",value = "类型")
	private String type;

	@ApiModelProperty(name = "status",value = "是否启用")
	private Integer status;

	@ApiModelProperty(name = "sort",value = "排序")
	private Integer sort;

}
