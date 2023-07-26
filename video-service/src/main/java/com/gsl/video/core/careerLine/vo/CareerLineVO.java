package com.gsl.video.core.careerLine.vo;

import com.gsl.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 事业线分类 VO类
 * @author system
 * @since 2023-05-15 14:28:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CareerLineVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "name",value = "事业线名称，确保唯一性")
	private String name;

	@ApiModelProperty(name = "nameEn",value = "事业线名称(英文)")
	private String nameEn;

	@ApiModelProperty(name = "sort",value = "排序")
	private Integer sort;

}
