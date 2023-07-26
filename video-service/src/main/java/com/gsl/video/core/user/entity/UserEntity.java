package com.gsl.video.core.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * User Entity类
 * @author system
 * @since 2023-05-08 15:26:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class UserEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "userId",value = "用户ID")
	@TableField("user_id")
	private Long userId;

	@ApiModelProperty(name = "name",value = "用户名")
	@TableField("name_i18n")
	private String name;

	@ApiModelProperty(name = "number",value = "用户编码")
	@TableField("number")
	private String number;

	@ApiModelProperty(name = "amount",value = "金额")
	@TableField("amount")
	private BigDecimal amount;

	@ApiModelProperty(name = "qty",value = "数量")
	@TableField("qty")
	private BigDecimal qty;

	@ApiModelProperty(name = "status",value = "状态: 0 在职,1离职,")
	@TableField("status")
	private Integer status;

}