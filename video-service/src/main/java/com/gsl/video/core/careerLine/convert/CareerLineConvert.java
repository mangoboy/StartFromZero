package com.gsl.video.core.careerLine.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.careerLine.dto.CareerLineAddDTO;
import com.gsl.video.core.careerLine.dto.CareerLineReqDTO;
import com.gsl.video.core.careerLine.entity.CareerLineEntity;
import com.gsl.video.core.careerLine.vo.CareerLineVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", imports = {BaseEntity.class, BaseVO.class})
public interface CareerLineConvert {

	CareerLineConvert INSTANCE = Mappers.getMapper(CareerLineConvert.class);

	/**
	 * Entity 转 VO
	 *
	 * @param list 参数
	 * @return list
	 */
	List<CareerLineVO> entity2VOList(List<CareerLineEntity> list);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	CareerLineEntity addDTO2Entity(CareerLineAddDTO dto);

	/**
	 * 查询、修改 DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	CareerLineEntity reqDTO2Entity(CareerLineReqDTO dto);

	/**
	 * Entity 转 VO
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	CareerLineVO entity2VO(CareerLineEntity dto);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param list 参数
	 * @return Entity
	 */
	List<CareerLineEntity> addDTO2EntityList(List<CareerLineAddDTO> list);
}
