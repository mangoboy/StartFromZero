package com.gsl.video.core.sysDict.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 系统字典 Entity类
 * @author taojirun
 * @date 2023-05-23 14:16:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_dict")
public class SysDictEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "label",value = "标签")
	@TableField("label")
	private String label;

	@ApiModelProperty(name = "value",value = "标签值")
	@TableField("value")
	private String value;

	@ApiModelProperty(name = "type",value = "类型")
	@TableField("type")
	private String type;

	@ApiModelProperty(name = "status",value = "是否启用")
	@TableField("status")
	private Integer status;

	@ApiModelProperty(name = "sort",value = "排序")
	@TableField("sort")
	private Integer sort;

}