package com.gsl.video.core.video.vo;

import com.gsl.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 视频扩展 VO类
 * @author system
 * @since 2023-05-12 15:24:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VideoExtVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "videoId",value = "视频主键")
	private String videoId;

	@ApiModelProperty(name = "clickNum",value = "视频点击量")
	private Integer clickNum;

	@ApiModelProperty(name = "likeNum",value = "视频点赞量")
	private Integer likeNum;

	@ApiModelProperty(name = "collectNum",value = "视频收藏量")
	private Integer collectNum;

	@ApiModelProperty(name = "shareNum",value = "视频转发数")
	private Integer shareNum;

}
