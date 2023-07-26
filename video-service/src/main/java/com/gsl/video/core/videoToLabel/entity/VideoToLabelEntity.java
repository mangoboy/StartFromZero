package com.gsl.video.core.videoToLabel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 视频-标签对应 Entity类
 * @author system
 * @date 2023-05-24 10:33:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_video_to_label")
public class VideoToLabelEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "videoId",value = "视频主键")
	@TableField("video_id")
	private String videoId;

	@ApiModelProperty(name = "labelId",value = "标签主键")
	@TableField("label_id")
	private String labelId;

}