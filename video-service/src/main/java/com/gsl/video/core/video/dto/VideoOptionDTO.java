package com.gsl.video.core.video.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * Video 查询、更新ReqDTO类
 *
 * @author system
 * @date 2023-05-12 16:21:57
 */
@Data
@ApiModel(value = "VideoExt查询、更新ReqDTO类")
public class VideoOptionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(name = "videoId", value = "视频id")
    private String videoId;

    @NotNull
    @ApiModelProperty(name = "isAdd", value = "是否增加 点赞、点击、收藏量")
    private Boolean isAdd = true;

    @NotBlank
    @ApiModelProperty(name = "optionType", value = "CLICK:点击、LIKE:点赞、COLLECT:收藏、SHARE:分享")
    private String optionType;

}
