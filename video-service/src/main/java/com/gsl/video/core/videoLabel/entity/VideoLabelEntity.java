package com.gsl.video.core.videoLabel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 视频标签 Entity类
 * @author system
 * @since 2023-05-15 14:33:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_video_label")
public class VideoLabelEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "name",value = "标签名称")
	@TableField("name")
	private String name;

}