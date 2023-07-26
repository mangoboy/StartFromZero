package com.gsl.video.core.videoUrl.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 视频url信息 VO类
 * @author system
 * @date 2023-05-22 10:09:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VideoUrlVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "url",value = "视频地址")
	private String url;

	@ApiModelProperty(name = "streamType",value = "流类型")
	private String streamType;

	@ApiModelProperty(name = "resolution",value = "分辨率")
	private String resolution;

}
