package com.gsl.video.core.videoUrl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsl.video.core.videoUrl.dto.VideoUrlReqDTO;
import com.gsl.video.core.videoUrl.entity.VideoUrlEntity;

import java.util.List;

/**
 * 视频url信息 Mapper类
 * @author system
 * @date 2023-05-22 10:09:40
 */
public interface VideoUrlMapper extends BaseMapper<VideoUrlEntity> {

	/**
	 * 获取列表
	 * @param dto 参数
	 * @return 列表
	 */
	List<VideoUrlEntity> getList(VideoUrlReqDTO dto);

}
