package com.gsl.video.core.video.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 视频点击 DTO类
 * @author taojirun
 * @date 2023-05-22
 */
@Data
@ApiModel(value = "VideoClick DTO")
public class VideoClickDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "videoId 不能为空")
	@ApiModelProperty(name = "videoId", value = "视频id")
	private String videoId;

}
