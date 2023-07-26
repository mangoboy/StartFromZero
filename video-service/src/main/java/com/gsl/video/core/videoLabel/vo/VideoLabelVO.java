package com.gsl.video.core.videoLabel.vo;

import com.gsl.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 视频标签 VO类
 * @author system
 * @since 2023-05-15 14:33:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VideoLabelVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "name",value = "标签名称")
	private String name;

	@ApiModelProperty(name = "videoId",value = "视频id")
	private String videoId;

	@ApiModelProperty(name = "labelId",value = "标签id")
	private String labelId;

	@ApiModelProperty(name = "to_label_id",value = "视频-标签对应表id")
	private String toLabelId;

}
