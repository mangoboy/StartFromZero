package com.gsl.video.core.careerLine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsl.video.core.careerLine.dto.CareerLineReqDTO;
import com.gsl.video.core.careerLine.entity.CareerLineEntity;

import java.util.List;

/**
 * 事业线分类 Mapper类
 * @author system
 */
public interface CareerLineMapper extends BaseMapper<CareerLineEntity> {

	/**
	 * 获取列表
	 * @param dto 参数
	 * @return 列表
	 */
	List<CareerLineEntity> getList(CareerLineReqDTO dto);

}
