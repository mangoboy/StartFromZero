package com.gsl.video.core.videoToLabel.dto;

import com.gsl.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 视频-标签对应 查询、更新ReqDTO类
 * @author system
 * @date 2023-05-24 10:33:44
 */
@Data
@ApiModel(value = "视频-标签对应查询、更新ReqDTO类")
public class VideoToLabelReqDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "videoId",value = "视频主键")
	private String videoId;

	@ApiModelProperty(name = "labelId",value = "标签主键")
	private String labelId;

}
