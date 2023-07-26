package com.gsl.video.core.careerLineToDefaultLabel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 事业线-默认标签对应 Entity类
 * @author system
 * @since 2023-05-15 14:42:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_career_line_to_default_label")
public class CareerLineToDefaultLabelEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "careerLineId",value = "事业线主键")
	@TableField("career_line_id")
	private Long careerLineId;

	@ApiModelProperty(name = "labelId",value = "标签主键")
	@TableField("label_id")
	private Long labelId;

}