package com.gsl.video.core.videoToLabel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsl.common.utils.PageUtil;
import com.gsl.video.core.videoToLabel.convert.VideoToLabelConvert;
import com.gsl.video.core.videoToLabel.dto.VideoToLabelAddDTO;
import com.gsl.video.core.videoToLabel.dto.VideoToLabelReqDTO;
import com.gsl.video.core.videoToLabel.entity.VideoToLabelEntity;
import com.gsl.video.core.videoToLabel.mapper.VideoToLabelMapper;
import com.gsl.video.core.videoToLabel.service.VideoToLabelService;
import com.gsl.video.core.videoToLabel.vo.VideoToLabelVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


/**
 * 视频-标签对应Service实现类
 * @author system
 * @date 2023-05-24 10:33:44
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class VideoToLabelServiceImpl extends ServiceImpl<VideoToLabelMapper, VideoToLabelEntity> implements VideoToLabelService {

	@Resource
	private VideoToLabelMapper videoToLabelMapper;

	@Resource
	private VideoToLabelConvert videoToLabelConvert;

	@Override
	public PageInfo<VideoToLabelVO> list(VideoToLabelReqDTO dto) {
		PageUtil.startPage(dto);
		VideoToLabelEntity entity = videoToLabelConvert.reqDTO2Entity(dto);
		LambdaQueryWrapper<VideoToLabelEntity> wrapper = Wrappers.lambdaQuery(entity);
		List<VideoToLabelEntity> list = list(wrapper);
		List<VideoToLabelVO> voList = videoToLabelConvert.entity2VOList(list);
		return PageUtil.page(list, voList);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public boolean add(VideoToLabelAddDTO dto) {
		VideoToLabelEntity entity = videoToLabelConvert.addDTO2Entity(dto);
		return save(entity);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public boolean update(VideoToLabelReqDTO dto) {
		VideoToLabelEntity entity = videoToLabelConvert.reqDTO2Entity(dto);
		return updateById(entity);
	}

	@Override
	public VideoToLabelVO get(Long id) {
		VideoToLabelVO vo = videoToLabelConvert.entity2VO(getById(id));
		return Optional.ofNullable(vo).orElse(new VideoToLabelVO());
	}
}
