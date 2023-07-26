package com.gsl.video.core.careerLine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsl.video.core.careerLine.convert.CareerLineConvert;
import com.gsl.video.core.careerLine.dto.CareerLineAddDTO;
import com.gsl.video.core.careerLine.dto.CareerLineReqDTO;
import com.gsl.video.core.careerLine.entity.CareerLineEntity;
import com.gsl.video.core.careerLine.mapper.CareerLineMapper;
import com.gsl.video.core.careerLine.service.CareerLineService;
import com.gsl.video.core.careerLine.vo.CareerLineVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


/**
 * Service实现类
 * @author system
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class CareerLineServiceImpl extends ServiceImpl<CareerLineMapper, CareerLineEntity> implements CareerLineService {

	@Resource
	private CareerLineMapper careerLineMapper;

	@Override
	public PageInfo<CareerLineVO> list(CareerLineReqDTO dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		CareerLineEntity entity = CareerLineConvert.INSTANCE.reqDTO2Entity(dto);
		LambdaQueryWrapper<CareerLineEntity> wrapper = Wrappers.lambdaQuery(entity);
		List<CareerLineEntity> list = list(wrapper);
		List<CareerLineVO> voList = CareerLineConvert.INSTANCE.entity2VOList(list);
		return new PageInfo<>(voList);
	}

	@Transactional(rollbackFor = {Exception.class, Error.class})
	@Override
	public boolean add(CareerLineAddDTO dto) {
		CareerLineEntity entity = CareerLineConvert.INSTANCE.addDTO2Entity(dto);
		return save(entity);
	}

	@Transactional(rollbackFor = {Exception.class, Error.class})
	@Override
	public boolean update(CareerLineReqDTO dto) {
		CareerLineEntity entity = CareerLineConvert.INSTANCE.reqDTO2Entity(dto);
		return updateById(entity);
	}

	@Transactional(rollbackFor = {Exception.class, Error.class})
	@Override
	public boolean delete(List<Long> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			log.error("【删除失败】参数为空！");
			return false;
		}
		return removeByIds(ids);
	}
	@Override
	public CareerLineVO get(Long id) {
		CareerLineVO vo = CareerLineConvert.INSTANCE.entity2VO(getById(id));
		return Optional.ofNullable(vo).orElse(new CareerLineVO());
	}
	@Transactional(rollbackFor = {Exception.class, Error.class})
	@Override
	public boolean batch(List<CareerLineAddDTO> dtos) {
		List<CareerLineEntity> entityList = CareerLineConvert.INSTANCE.addDTO2EntityList(dtos);
		return saveBatch(entityList);
	}

	@Override
	public List<CareerLineVO> listNoPage(CareerLineReqDTO dto) {
		dto.setOrderby("sort asc");
		dto.setStart(-1);
		List<CareerLineEntity> list = careerLineMapper.getList(dto);
		List<CareerLineVO> voList = CareerLineConvert.INSTANCE.entity2VOList(list);
		return voList;
	}

}
