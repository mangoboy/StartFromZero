package com.gsl.video.core.videoLabel.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.videoLabel.dto.VideoLabelAddDTO;
import com.gsl.video.core.videoLabel.dto.VideoLabelReqDTO;
import com.gsl.video.core.videoLabel.entity.VideoLabelEntity;
import com.gsl.video.core.videoLabel.vo.VideoLabelVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-26T13:38:10+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class VideoLabelConvertImpl implements VideoLabelConvert {

    @Override
    public List<VideoLabelVO> entity2VOList(List<VideoLabelEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoLabelVO> list1 = new ArrayList<VideoLabelVO>( list.size() );
        for ( VideoLabelEntity videoLabelEntity : list ) {
            list1.add( entity2VO( videoLabelEntity ) );
        }

        return list1;
    }

    @Override
    public VideoLabelEntity addDTO2Entity(VideoLabelAddDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VideoLabelEntity videoLabelEntity = new VideoLabelEntity();

        videoLabelEntity.setName( dto.getName() );

        return videoLabelEntity;
    }

    @Override
    public VideoLabelEntity reqDTO2Entity(VideoLabelReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VideoLabelEntity videoLabelEntity = new VideoLabelEntity();

        videoLabelEntity.setId( dto.getId() );
        videoLabelEntity.setRemark( dto.getRemark() );
        videoLabelEntity.setName( dto.getName() );

        return videoLabelEntity;
    }

    @Override
    public VideoLabelVO entity2VO(VideoLabelEntity dto) {
        if ( dto == null ) {
            return null;
        }

        VideoLabelVO videoLabelVO = new VideoLabelVO();

        videoLabelVO.setId( dto.getId() );
        videoLabelVO.setCreateBy( dto.getCreateBy() );
        videoLabelVO.setCreateTime( dto.getCreateTime() );
        videoLabelVO.setUpdateBy( dto.getUpdateBy() );
        videoLabelVO.setUpdateTime( dto.getUpdateTime() );
        videoLabelVO.setRemark( dto.getRemark() );
        videoLabelVO.setName( dto.getName() );

        return videoLabelVO;
    }

    @Override
    public List<VideoLabelEntity> addDTO2EntityList(List<VideoLabelAddDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoLabelEntity> list1 = new ArrayList<VideoLabelEntity>( list.size() );
        for ( VideoLabelAddDTO videoLabelAddDTO : list ) {
            list1.add( addDTO2Entity( videoLabelAddDTO ) );
        }

        return list1;
    }
}
