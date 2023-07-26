package com.gsl.video.core.video.dto;

import com.gsl.common.dto.BaseDTO;
import com.gsl.video.core.videoUrl.dto.VideoUrlAddDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * Video 查询、更新ReqDTO类
 * @author system
 * @date 2023-05-12 16:21:57
 */
@Data
@ApiModel(value = "Video查询、更新ReqDTO类")
public class VideoReqDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "busiType",value = "业务类型")
	private String busiType;

	@ApiModelProperty(name = "careerLine",value = "事业线key值")
	private String careerLine;

	@ApiModelProperty(name = "title",value = "视频主题")
	private String title;

	@ApiModelProperty(name = "videoDesc",value = "视频描述")
	private String videoDesc;

	@ApiModelProperty(name = "coverUrl",value = "封面图片地址")
	private String coverUrl;

	@ApiModelProperty(name = "urlList",value = "视频播放地址")
	private List<VideoUrlAddDTO> urlList;

	@ApiModelProperty(name = "labelList",value = "标签")
	private List<String> labelList;

	@ApiModelProperty(name = "orderby",value = "排序字段")
	private List<String> orderby;

	@ApiModelProperty(name = "start",value = "数据开始下标")
	private Integer start;

	@ApiModelProperty(name = "length",value = "数据数量")
	private Integer length;

}
