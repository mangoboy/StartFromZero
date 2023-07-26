package com.gsl.video.core.video.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.video.entity.VideoExtEntity;
import com.gsl.video.core.video.vo.VideoExtVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", imports = {BaseEntity.class, BaseVO.class})
public interface VideoExtConvert {

    VideoExtConvert INSTANCE = Mappers.getMapper(VideoExtConvert.class);

    /**
     * Entity 转 VO
     *
     * @param list 参数
     * @return list
     */
    List<VideoExtVO> entity2VOList(List<VideoExtEntity> list);


    /**
     * Entity 转 VO
     *
     * @param dto 参数
     * @return Entity
     */
    VideoExtVO entity2VO(VideoExtEntity dto);

}
