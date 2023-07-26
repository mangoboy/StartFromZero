package com.gsl.video.core.videoToLabel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsl.video.core.videoToLabel.dto.VideoToLabelAddDTO;
import com.gsl.video.core.videoToLabel.dto.VideoToLabelReqDTO;
import com.gsl.video.core.videoToLabel.entity.VideoToLabelEntity;
import com.gsl.video.core.videoToLabel.vo.VideoToLabelVO;
import com.github.pagehelper.PageInfo;

/**
 * 视频-标签对应 Service类
 * @author system
 * @date 2023-05-24 10:33:44
 */
public interface VideoToLabelService extends IService<VideoToLabelEntity> {

	/**
	 * 获取列表（分页）
	 * @param dto 请求参数
	 * @return 列表
	 */
	PageInfo<VideoToLabelVO> list(VideoToLabelReqDTO dto);

	/**
	 * 新增
	 * @param dto 参数
	 * @return true/false
	 */
	boolean add(VideoToLabelAddDTO dto);

	/**
	 * 更新
	 * @param dto 参数
	 * @return true/false
	 */
	boolean update(VideoToLabelReqDTO dto);


	/**
	 * 根据id获取
	 *
	 * @param id 主键
	 * @return VideoToLabelVO
	 */
	VideoToLabelVO get(Long id);

}
