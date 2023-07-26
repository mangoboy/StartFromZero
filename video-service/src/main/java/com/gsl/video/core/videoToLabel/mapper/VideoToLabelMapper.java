package com.gsl.video.core.videoToLabel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsl.video.core.videoToLabel.dto.VideoToLabelReqDTO;
import com.gsl.video.core.videoToLabel.entity.VideoToLabelEntity;

import java.util.List;

/**
 * 视频-标签对应 Mapper类
 * @author system
 * @date 2023-05-24 10:33:44
 */
public interface VideoToLabelMapper extends BaseMapper<VideoToLabelEntity> {

	/**
	 * 获取列表
	 * @param dto 参数
	 * @return 列表
	 */
	List<VideoToLabelEntity> getList(VideoToLabelReqDTO dto);

}
