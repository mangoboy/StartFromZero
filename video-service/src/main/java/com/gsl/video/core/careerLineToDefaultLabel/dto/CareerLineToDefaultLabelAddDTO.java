package com.gsl.video.core.careerLineToDefaultLabel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * CareerLineToDefaultLabel AddDTO类
 * @author system
 * @date 2023-05-07 19:59:19
 */
@Data
@ApiModel(value = "CareerLineToDefaultLabel AddDTO类")
public class CareerLineToDefaultLabelAddDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	@ApiModelProperty(name = "careerLineId",value = "事业线主键")
	private Long careerLineId;

	@ApiModelProperty(name = "labelId",value = "标签主键")
	private Long labelId;

}
