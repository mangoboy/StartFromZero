package com.gsl.video.core.videoLabel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * VideoLabel AddDTO类
 * @author system
 * @date 2023-05-07 19:59:19
 */
@Data
@ApiModel(value = "VideoLabel AddDTO类")
public class VideoLabelAddDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	@ApiModelProperty(name = "name",value = "标签名称")
	private String name;

}
