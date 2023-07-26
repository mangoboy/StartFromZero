package com.gsl.video.core.careerLineToDefaultLabel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsl.video.core.careerLineToDefaultLabel.dto.CareerLineToDefaultLabelReqDTO;
import com.gsl.video.core.careerLineToDefaultLabel.entity.CareerLineToDefaultLabelEntity;

import java.util.List;

/**
 * 事业线-默认标签对应 Mapper类
 * @author system
 */
public interface CareerLineToDefaultLabelMapper extends BaseMapper<CareerLineToDefaultLabelEntity> {

	/**
	 * 获取列表
	 * @param dto 参数
	 * @return 列表
	 */
	List<CareerLineToDefaultLabelEntity> getList(CareerLineToDefaultLabelReqDTO dto);

}
