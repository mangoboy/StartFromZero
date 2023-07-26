package com.gsl.video.core.sysDict.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsl.common.utils.PageUtil;
import com.gsl.video.core.sysDict.convert.SysDictConvert;
import com.gsl.video.core.sysDict.dto.SysDictAddDTO;
import com.gsl.video.core.sysDict.dto.SysDictReqDTO;
import com.gsl.video.core.sysDict.entity.SysDictEntity;
import com.gsl.video.core.sysDict.mapper.SysDictMapper;
import com.gsl.video.core.sysDict.service.SysDictService;
import com.gsl.video.core.sysDict.vo.SysDictVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


/**
 * 系统字典Service实现类
 * @author taojirun
 * @date 2023-05-23 14:16:50
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictEntity> implements SysDictService {

	@Resource
	private SysDictMapper sysDictMapper;

	@Resource
	private SysDictConvert sysDictConvert;

	@Override
	public PageInfo<SysDictVO> list(SysDictReqDTO dto) {
		PageUtil.startPage(dto);
		SysDictEntity entity = sysDictConvert.reqDTO2Entity(dto);
		LambdaQueryWrapper<SysDictEntity> wrapper = Wrappers.lambdaQuery(entity);
		wrapper.orderByAsc(SysDictEntity::getSort);
		List<SysDictEntity> list = list(wrapper);
		List<SysDictVO> voList = sysDictConvert.entity2VOList(list);
		return PageUtil.page(list, voList);
	}

	@Override
	public List<SysDictVO> getListByType(String type) {
		LambdaQueryWrapper<SysDictEntity> wrapper = Wrappers.lambdaQuery();
		wrapper.eq(SysDictEntity::getType, type);
		wrapper.orderByAsc(SysDictEntity::getSort);
		List<SysDictEntity> list = list(wrapper);
		List<SysDictVO> voList = sysDictConvert.entity2VOList(list);
		return voList;
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public boolean add(SysDictAddDTO dto) {
		SysDictEntity entity = sysDictConvert.addDTO2Entity(dto);
		return save(entity);
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public boolean update(SysDictReqDTO dto) {
		SysDictEntity entity = sysDictConvert.reqDTO2Entity(dto);
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
	public SysDictVO get(Long id) {
		SysDictVO vo = sysDictConvert.entity2VO(getById(id));
		return Optional.ofNullable(vo).orElse(new SysDictVO());
	}

	@Override
	@Transactional(rollbackFor = {Exception.class, Error.class})
	public boolean batch(List<SysDictAddDTO> dtos) {
		List<SysDictEntity> entityList = sysDictConvert.addDTO2EntityList(dtos);
		return saveBatch(entityList);
	}
}
