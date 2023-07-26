package com.gsl.video.core.videoLabel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsl.video.core.videoLabel.dto.VideoLabelReqDTO;
import com.gsl.video.core.videoLabel.entity.VideoLabelEntity;
import com.gsl.video.core.videoLabel.vo.VideoLabelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 视频标签 Mapper类
 * @author system
 */
public interface VideoLabelMapper extends BaseMapper<VideoLabelEntity> {

	/**
	 * 获取列表
	 * @param dto 参数
	 * @return 列表
	 */
	List<VideoLabelEntity> getList(VideoLabelReqDTO dto);


//	List<VideoLabelVO> getListByVideoId(@Param("videoId") String videoId);


	/**
	 * 根据videoIds获取标签列表
	 *
	 * @param videoId
	 * @return 列表
	 */
	List<VideoLabelVO> getListByVideoIds(@Param("videoIds") List<String> videoId);

}
