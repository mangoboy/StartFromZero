package com.gsl.video.core.videoToLabel.vo;

import com.gsl.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 视频-标签对应 VO类
 * @author system
 * @date 2023-05-24 10:33:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VideoToLabelVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "videoId",value = "视频主键")
	private String videoId;

	@ApiModelProperty(name = "labelId",value = "标签主键")
	private String labelId;

}
