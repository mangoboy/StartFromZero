package com.gsl.video.core.careerLineToDefaultLabel.vo;

import com.gsl.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 事业线-默认标签对应 VO类
 * @author system
 * @since 2023-05-15 14:42:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CareerLineToDefaultLabelVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "careerLineId",value = "事业线主键")
	private Long careerLineId;

	@ApiModelProperty(name = "labelId",value = "标签主键")
	private Long labelId;

}
