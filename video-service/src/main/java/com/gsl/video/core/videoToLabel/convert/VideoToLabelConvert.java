package com.gsl.video.core.videoToLabel.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.videoToLabel.dto.VideoToLabelAddDTO;
import com.gsl.video.core.videoToLabel.dto.VideoToLabelReqDTO;
import com.gsl.video.core.videoToLabel.entity.VideoToLabelEntity;
import com.gsl.video.core.videoToLabel.vo.VideoToLabelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 视频-标签对应实体转换类
 * @author system
 * @date 2023-05-24 10:33:44
 */
@Mapper(componentModel = "spring", imports = {BaseEntity.class, BaseVO.class})
public interface VideoToLabelConvert {

	VideoToLabelConvert INSTANCE = Mappers.getMapper(VideoToLabelConvert.class);

	/**
	 * Entity 转 VO
	 *
	 * @param list 参数
	 * @return list
	 */
	List<VideoToLabelVO> entity2VOList(List<VideoToLabelEntity> list);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoToLabelEntity addDTO2Entity(VideoToLabelAddDTO dto);

	/**
	 * 查询、修改 DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoToLabelEntity reqDTO2Entity(VideoToLabelReqDTO dto);

	/**
	 * Entity 转 VO
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoToLabelVO entity2VO(VideoToLabelEntity dto);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param list 参数
	 * @return Entity
	 */
	List<VideoToLabelEntity> addDTO2EntityList(List<VideoToLabelAddDTO> list);
}
