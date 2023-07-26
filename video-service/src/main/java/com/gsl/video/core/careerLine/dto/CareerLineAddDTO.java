package com.gsl.video.core.careerLine.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * CareerLine AddDTO类
 * @author system
 * @date 2023-05-07 19:59:19
 */
@Data
@ApiModel(value = "CareerLine AddDTO类")
public class CareerLineAddDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	@ApiModelProperty(name = "name",value = "事业线名称，确保唯一性")
	private String name;

	@ApiModelProperty(name = "nameEn",value = "事业线名称(英文)")
	private String nameEn;

	@ApiModelProperty(name = "sort",value = "排序")
	private Integer sort;

}
