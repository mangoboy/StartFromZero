package com.gsl.video.core.video.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.video.dto.VideoAddDTO;
import com.gsl.video.core.video.dto.VideoReqDTO;
import com.gsl.video.core.video.entity.VideoEntity;
import com.gsl.video.core.video.vo.VideoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", imports = {BaseEntity.class, BaseVO.class})
public interface VideoConvert {

	VideoConvert INSTANCE = Mappers.getMapper(VideoConvert.class);

	/**
	 * Entity 转 VO
	 *
	 * @param list 参数
	 * @return list
	 */
	List<VideoVO> entity2VOList(List<VideoEntity> list);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoEntity addDTO2Entity(VideoAddDTO dto);

	/**
	 * 查询、修改 DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoEntity reqDTO2Entity(VideoReqDTO dto);

	/**
	 * Entity 转 VO
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoVO entity2VO(VideoEntity dto);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param list 参数
	 * @return Entity
	 */
	List<VideoEntity> addDTO2EntityList(List<VideoAddDTO> list);
}
