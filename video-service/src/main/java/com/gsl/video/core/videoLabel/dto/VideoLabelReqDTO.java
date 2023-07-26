package com.gsl.video.core.videoLabel.dto;

import com.gsl.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * VideoLabel 查询、更新ReqDTO类
 * @author system
 * @date 2023-05-15 14:33:58
 */
@Data
@ApiModel(value = "VideoLabel查询、更新ReqDTO类")
public class VideoLabelReqDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "name",value = "标签名称")
	private String name;

}
