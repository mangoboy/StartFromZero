package com.gsl.video.core.video.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.video.dto.VideoAddDTO;
import com.gsl.video.core.video.dto.VideoReqDTO;
import com.gsl.video.core.video.entity.VideoEntity;
import com.gsl.video.core.video.vo.VideoVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-25T17:21:56+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class VideoConvertImpl implements VideoConvert {

    @Override
    public List<VideoVO> entity2VOList(List<VideoEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoVO> list1 = new ArrayList<VideoVO>( list.size() );
        for ( VideoEntity videoEntity : list ) {
            list1.add( entity2VO( videoEntity ) );
        }

        return list1;
    }

    @Override
    public VideoEntity addDTO2Entity(VideoAddDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VideoEntity videoEntity = new VideoEntity();

        videoEntity.setBusiType( dto.getBusiType() );
        videoEntity.setCareerLine( dto.getCareerLine() );
        videoEntity.setTitle( dto.getTitle() );
        videoEntity.setVideoDesc( dto.getVideoDesc() );
        videoEntity.setCoverUrl( dto.getCoverUrl() );

        return videoEntity;
    }

    @Override
    public VideoEntity reqDTO2Entity(VideoReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VideoEntity videoEntity = new VideoEntity();

        videoEntity.setId( dto.getId() );
        videoEntity.setRemark( dto.getRemark() );
        videoEntity.setBusiType( dto.getBusiType() );
        videoEntity.setCareerLine( dto.getCareerLine() );
        videoEntity.setTitle( dto.getTitle() );
        videoEntity.setVideoDesc( dto.getVideoDesc() );
        videoEntity.setCoverUrl( dto.getCoverUrl() );

        return videoEntity;
    }

    @Override
    public VideoVO entity2VO(VideoEntity dto) {
        if ( dto == null ) {
            return null;
        }

        VideoVO videoVO = new VideoVO();

        videoVO.setId( dto.getId() );
        videoVO.setCreateBy( dto.getCreateBy() );
        videoVO.setCreateTime( dto.getCreateTime() );
        videoVO.setUpdateBy( dto.getUpdateBy() );
        videoVO.setUpdateTime( dto.getUpdateTime() );
        videoVO.setRemark( dto.getRemark() );
        videoVO.setBusiType( dto.getBusiType() );
        videoVO.setCareerLine( dto.getCareerLine() );
        videoVO.setTitle( dto.getTitle() );
        videoVO.setVideoDesc( dto.getVideoDesc() );
        videoVO.setCoverUrl( dto.getCoverUrl() );

        return videoVO;
    }

    @Override
    public List<VideoEntity> addDTO2EntityList(List<VideoAddDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoEntity> list1 = new ArrayList<VideoEntity>( list.size() );
        for ( VideoAddDTO videoAddDTO : list ) {
            list1.add( addDTO2Entity( videoAddDTO ) );
        }

        return list1;
    }
}
