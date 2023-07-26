package com.gsl.video.core.video.vo;

import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.videoUrl.vo.VideoUrlVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;


/**
 * 视频 VO类
 * @author system
 * @since 2023-05-12 16:21:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class VideoVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "busiType",value = "业务类型")
	private String busiType;

	@ApiModelProperty(name = "careerLine",value = "事业线key")
	private String careerLine;

	@ApiModelProperty(name = "careerLineVal",value = "事业线value")
	private String careerLineVal;

	@ApiModelProperty(name = "title",value = "视频主题")
	private String title;

	@ApiModelProperty(name = "videoDesc",value = "视频描述")
	private String videoDesc;

	@ApiModelProperty(name = "coverUrl",value = "封面图片地址")
	private String coverUrl;

	@ApiModelProperty(name = "clickNum",value = "视频点击量")
	private Integer clickNum;

	@ApiModelProperty(name = "likeNum",value = "视频点赞量")
	private Integer likeNum;

	@ApiModelProperty(name = "collectNum",value = "视频收藏量")
	private Integer collectNum;

	@ApiModelProperty(name = "shareNum",value = "视频转发数")
	private Integer shareNum;

	@ApiModelProperty(name = "urlList",value = "视频播放地址")
	private List<VideoUrlVO> urlList;

	@ApiModelProperty(name = "labelList",value = "标签")
	private List<String> labelList;

}
