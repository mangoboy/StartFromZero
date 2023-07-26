package com.gsl.video.core.careerLineToDefaultLabel.dto;

import com.gsl.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * CareerLineToDefaultLabel 查询、更新ReqDTO类
 * @author system
 * @date 2023-05-15 14:42:25
 */
@Data
@ApiModel(value = "CareerLineToDefaultLabel查询、更新ReqDTO类")
public class CareerLineToDefaultLabelReqDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "careerLineId",value = "事业线主键")
	private Long careerLineId;

	@ApiModelProperty(name = "labelId",value = "标签主键")
	private Long labelId;

}
