package com.gsl.video.core.video.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 视频 Entity类
 * @author system
 * @since 2023-05-12 16:21:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_video")
public class VideoEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "busiType",value = "业务类型")
	@TableField("busi_type")
	private String busiType;

	@ApiModelProperty(name = "careerLineId",value = "事业线key值")
	@TableField("career_line")
	private String careerLine;

	@ApiModelProperty(name = "title",value = "视频主题")
	@TableField("title")
	private String title;

	@ApiModelProperty(name = "videoDesc",value = "视频描述")
	@TableField("video_desc")
	private String videoDesc;

	@ApiModelProperty(name = "coverUrl",value = "封面图片地址")
	@TableField("cover_url")
	private String coverUrl;

}