package com.gsl.video.core.sysDict.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.sysDict.dto.SysDictAddDTO;
import com.gsl.video.core.sysDict.dto.SysDictReqDTO;
import com.gsl.video.core.sysDict.entity.SysDictEntity;
import com.gsl.video.core.sysDict.vo.SysDictVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统字典实体转换类
 * @author taojirun
 * @date 2023-05-23 14:16:50
 */
@Mapper(componentModel = "spring", imports = {BaseEntity.class, BaseVO.class})
public interface SysDictConvert {

	SysDictConvert INSTANCE = Mappers.getMapper(SysDictConvert.class);

	/**
	 * Entity 转 VO
	 *
	 * @param list 参数
	 * @return list
	 */
	List<SysDictVO> entity2VOList(List<SysDictEntity> list);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	SysDictEntity addDTO2Entity(SysDictAddDTO dto);

	/**
	 * 查询、修改 DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	SysDictEntity reqDTO2Entity(SysDictReqDTO dto);

	/**
	 * Entity 转 VO
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	SysDictVO entity2VO(SysDictEntity dto);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param list 参数
	 * @return Entity
	 */
	List<SysDictEntity> addDTO2EntityList(List<SysDictAddDTO> list);
}
