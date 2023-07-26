package com.gsl.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 *
 * @author system
 * @since 2023-04-28 09:55:34
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "主键")
    private String id;

    @ApiModelProperty(name = "createBy", value = "创建者账号")
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateBy", value = "更新者账号")
    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;
}
