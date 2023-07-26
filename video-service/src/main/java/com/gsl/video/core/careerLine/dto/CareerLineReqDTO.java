package com.gsl.video.core.careerLine.dto;

import com.gsl.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * CareerLine 查询、更新ReqDTO类
 * @author system
 * @date 2023-05-15 14:28:35
 */
@Data
@ApiModel(value = "CareerLine查询、更新ReqDTO类")
public class CareerLineReqDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "name",value = "事业线名称，确保唯一性")
	private String name;

	@ApiModelProperty(name = "nameEn",value = "事业线名称(英文)")
	private String nameEn;

	@ApiModelProperty(name = "sort",value = "排序")
	private Integer sort;

	@ApiModelProperty(name = "orderby",value = "排序字段")
	private String orderby;

	@ApiModelProperty(name = "start",value = "数据开始下标")
	private Integer start;

	@ApiModelProperty(name = "length",value = "数据数量")
	private Integer length;

}
