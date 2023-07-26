package com.gsl.video.core.videoLabel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsl.common.utils.PageUtil;
import com.gsl.video.core.videoLabel.convert.VideoLabelConvert;
import com.gsl.video.core.videoLabel.dto.VideoLabelAddDTO;
import com.gsl.video.core.videoLabel.dto.VideoLabelReqDTO;
import com.gsl.video.core.videoLabel.entity.VideoLabelEntity;
import com.gsl.video.core.videoLabel.mapper.VideoLabelMapper;
import com.gsl.video.core.videoLabel.service.VideoLabelService;
import com.gsl.video.core.videoLabel.vo.VideoLabelVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


/**
 * 视频标签Service实现类
 * @author system
 * @date 2023-05-24 10:51:42
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class VideoLabelServiceImpl extends ServiceImpl<VideoLabelMapper, VideoLabelEntity> implements VideoLabelService {

	@Resource
	private VideoLabelMapper videoLabelMapper;

	@Resource
	private VideoLabelConvert videoLabelConvert;

	@Override
	public PageInfo<VideoLabelVO> list(VideoLabelReqDTO dto) {
		PageUtil.startPage(dto);
		VideoLabelEntity entity = videoLabelConvert.reqDTO2Entity(dto);
		LambdaQueryWrapper<VideoLabelEntity> wrapper = Wrappers.lambdaQuery(entity);
		List<VideoLabelEntity> list = list(wrapper);
		List<VideoLabelVO> voList = videoLabelConvert.entity2VOList(list);
		return PageUtil.page(list, voList);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public boolean add(VideoLabelAddDTO dto) {
		VideoLabelEntity entity = videoLabelConvert.addDTO2Entity(dto);
		return save(entity);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public boolean update(VideoLabelReqDTO dto) {
		VideoLabelEntity entity = videoLabelConvert.reqDTO2Entity(dto);
		return updateById(entity);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public boolean delete(List<String> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			log.error("【删除失败】参数为空！");
			return false;
		}
		return removeByIds(ids);
	}

	@Override
	public VideoLabelVO get(Long id) {
		VideoLabelVO vo = videoLabelConvert.entity2VO(getById(id));
		return Optional.ofNullable(vo).orElse(new VideoLabelVO());
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public boolean batch(List<VideoLabelAddDTO> dtos) {
		List<VideoLabelEntity> entityList = videoLabelConvert.addDTO2EntityList(dtos);
		return saveBatch(entityList);
	}
}
