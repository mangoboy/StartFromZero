package com.gsl.video.core.user.dto;

import com.gsl.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * User 查询、更新ReqDTO类
 *
 * @author system
 * @date 2023-05-08 15:26:31
 */
@Data
@ApiModel(value = "User查询、更新ReqDTO类")
public class UserReqDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "userId", value = "用户ID")
    private Long userId;

    @ApiModelProperty(name = "name", value = "用户名")
    private String name;

    @ApiModelProperty(name = "number", value = "用户编码")
    private String number;

    @ApiModelProperty(name = "amount", value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(name = "qty", value = "数量")
    private BigDecimal qty;

    @ApiModelProperty(name = "status", value = "状态: 0 在职,1离职,")
    private Integer status;

}
