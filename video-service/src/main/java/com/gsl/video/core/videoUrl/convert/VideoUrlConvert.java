package com.gsl.video.core.videoUrl.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.videoUrl.dto.VideoUrlAddDTO;
import com.gsl.video.core.videoUrl.dto.VideoUrlReqDTO;
import com.gsl.video.core.videoUrl.entity.VideoUrlEntity;
import com.gsl.video.core.videoUrl.vo.VideoUrlVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 视频url信息实体转换类
 * @author system
 * @date 2023-05-22 10:09:40
 */
@Mapper(componentModel = "spring", imports = {BaseEntity.class, BaseVO.class})
public interface VideoUrlConvert {

	VideoUrlConvert INSTANCE = Mappers.getMapper(VideoUrlConvert.class);

	/**
	 * Entity 转 VO
	 *
	 * @param list 参数
	 * @return list
	 */
	List<VideoUrlVO> entity2VOList(List<VideoUrlEntity> list);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoUrlEntity addDTO2Entity(VideoUrlAddDTO dto);

	/**
	 * 查询、修改 DTO 转 Entity
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoUrlEntity reqDTO2Entity(VideoUrlReqDTO dto);

	/**
	 * Entity 转 VO
	 *
	 * @param dto 参数
	 * @return Entity
	 */
	VideoUrlVO entity2VO(VideoUrlEntity dto);

	/**
	 * 新增DTO 转 Entity
	 *
	 * @param list 参数
	 * @return Entity
	 */
	List<VideoUrlEntity> addDTO2EntityList(List<VideoUrlAddDTO> list);
}
