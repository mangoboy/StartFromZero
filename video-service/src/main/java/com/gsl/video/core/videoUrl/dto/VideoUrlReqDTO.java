package com.gsl.video.core.videoUrl.dto;

import com.gsl.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 视频url信息 查询、更新ReqDTO类
 * @author system
 * @date 2023-05-22 10:09:40
 */
@Data
@ApiModel(value = "视频url信息查询、更新ReqDTO类")
public class VideoUrlReqDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "url",value = "视频地址")
	private String url;

	@ApiModelProperty(name = "streamType",value = "流类型")
	private String streamType;

	@ApiModelProperty(name = "resolution",value = "分辨率")
	private String resolution;

}
