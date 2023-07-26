package com.gsl.video.core.videoUrl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 视频url信息 Entity类
 * @author system
 * @date 2023-05-22 10:09:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_video_url")
public class VideoUrlEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "videoId",value = "视频主键")
	@TableField("video_id")
	private String videoId;

	@ApiModelProperty(name = "url",value = "视频地址")
	@TableField("url")
	private String url;

	@ApiModelProperty(name = "streamType",value = "流类型")
	@TableField("stream_type")
	private String streamType;

	@ApiModelProperty(name = "resolution",value = "分辨率")
	@TableField("resolution")
	private String resolution;

}