package com.gsl.video.core.video.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 视频扩展 Entity类
 * @author system
 * @since 2023-05-12 15:24:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_video_ext")
public class VideoExtEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "videoId",value = "视频主键")
	@TableField("video_id")
	private String videoId;

	@ApiModelProperty(name = "clickNum",value = "视频点击量")
	@TableField("click_num")
	private Integer clickNum;

	@ApiModelProperty(name = "likeNum",value = "视频点赞量")
	@TableField("like_num")
	private Integer likeNum;

	@ApiModelProperty(name = "collectNum",value = "视频收藏量")
	@TableField("collect_num")
	private Integer collectNum;

	@ApiModelProperty(name = "shareNum",value = "视频转发数")
	@TableField("share_num")
	private Integer shareNum;

}