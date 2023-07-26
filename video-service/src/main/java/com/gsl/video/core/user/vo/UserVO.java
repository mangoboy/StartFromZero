package com.gsl.video.core.user.vo;

import com.gsl.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * User VO类
 * @author system
 * @since 2023-05-08 15:26:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "userId",value = "用户ID")
	private Long userId;

	@ApiModelProperty(name = "name",value = "用户名")
	private String name;

	@ApiModelProperty(name = "number",value = "用户编码")
	private String number;

	@ApiModelProperty(name = "amount",value = "金额")
	private BigDecimal amount;

	@ApiModelProperty(name = "qty",value = "数量")
	private BigDecimal qty;

	@ApiModelProperty(name = "status",value = "状态: 0 在职,1离职,")
	private Integer status;

}
