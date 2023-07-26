package com.gsl.video.core.videoLabel.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.videoLabel.dto.VideoLabelAddDTO;
import com.gsl.video.core.videoLabel.dto.VideoLabelReqDTO;
import com.gsl.video.core.videoLabel.entity.VideoLabelEntity;
import com.gsl.video.core.videoLabel.vo.VideoLabelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 视频标签实体转换类
 * @author system
 * @date 2023-05-24 10:51:42
 */
@Mapper(componentModel = "spring", imports = {BaseEntity.class, BaseVO.class})
public interface VideoLabelConvert {

	VideoLabelConvert INSTANCE = Mappers.getMapper(VideoLabelConvert.class);

	/**
	 * Entity 转 VO
	 *
	 * @param list 参数
	 * @return list
	 */
	List<VideoLabelVO> entity2VOList(List<VideoLabelEntity> list);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoLabelEntity addDTO2Entity(VideoLabelAddDTO dto);

	/**
	 * 查询、修改 DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoLabelEntity reqDTO2Entity(VideoLabelReqDTO dto);

	/**
	 * Entity 转 VO
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoLabelVO entity2VO(VideoLabelEntity dto);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param list 参数
	 * @return Entity
	 */
	List<VideoLabelEntity> addDTO2EntityList(List<VideoLabelAddDTO> list);
}
