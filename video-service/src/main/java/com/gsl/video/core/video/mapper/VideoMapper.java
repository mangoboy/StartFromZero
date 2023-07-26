package com.gsl.video.core.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsl.video.core.video.dto.VideoReqDTO;
import com.gsl.video.core.video.entity.VideoEntity;
import com.gsl.video.core.video.vo.VideoVO;

import java.util.List;

/**
 * 视频 Mapper类
 * @author system
 */
public interface VideoMapper extends BaseMapper<VideoEntity> {

	/**
	 * 获取列表
	 * @param dto 参数
	 * @return 列表
	 */
	List<VideoEntity> getList(VideoReqDTO dto);

	List<VideoVO> getHomePageCareerList(VideoReqDTO dto);

}
