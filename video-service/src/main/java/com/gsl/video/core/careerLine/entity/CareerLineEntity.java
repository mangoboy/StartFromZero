package com.gsl.video.core.careerLine.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 事业线分类 Entity类
 * @author system
 * @since 2023-05-15 14:28:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_career_line")
public class CareerLineEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "name",value = "事业线名称，确保唯一性")
	@TableField("name")
	private String name;

	@ApiModelProperty(name = "nameEn",value = "事业线名称(英文)")
	@TableField("name_en")
	private String nameEn;

	@ApiModelProperty(name = "sort",value = "排序")
	@TableField("sort")
	private Integer sort;

}