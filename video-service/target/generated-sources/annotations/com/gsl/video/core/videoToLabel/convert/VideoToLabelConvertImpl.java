package com.gsl.video.core.videoToLabel.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.videoToLabel.dto.VideoToLabelAddDTO;
import com.gsl.video.core.videoToLabel.dto.VideoToLabelReqDTO;
import com.gsl.video.core.videoToLabel.entity.VideoToLabelEntity;
import com.gsl.video.core.videoToLabel.vo.VideoToLabelVO;
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
public class VideoToLabelConvertImpl implements VideoToLabelConvert {

    @Override
    public List<VideoToLabelVO> entity2VOList(List<VideoToLabelEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoToLabelVO> list1 = new ArrayList<VideoToLabelVO>( list.size() );
        for ( VideoToLabelEntity videoToLabelEntity : list ) {
            list1.add( entity2VO( videoToLabelEntity ) );
        }

        return list1;
    }

    @Override
    public VideoToLabelEntity addDTO2Entity(VideoToLabelAddDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VideoToLabelEntity videoToLabelEntity = new VideoToLabelEntity();

        videoToLabelEntity.setVideoId( dto.getVideoId() );
        videoToLabelEntity.setLabelId( dto.getLabelId() );

        return videoToLabelEntity;
    }

    @Override
    public VideoToLabelEntity reqDTO2Entity(VideoToLabelReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VideoToLabelEntity videoToLabelEntity = new VideoToLabelEntity();

        videoToLabelEntity.setId( dto.getId() );
        videoToLabelEntity.setRemark( dto.getRemark() );
        videoToLabelEntity.setVideoId( dto.getVideoId() );
        videoToLabelEntity.setLabelId( dto.getLabelId() );

        return videoToLabelEntity;
    }

    @Override
    public VideoToLabelVO entity2VO(VideoToLabelEntity dto) {
        if ( dto == null ) {
            return null;
        }

        VideoToLabelVO videoToLabelVO = new VideoToLabelVO();

        videoToLabelVO.setId( dto.getId() );
        videoToLabelVO.setCreateBy( dto.getCreateBy() );
        videoToLabelVO.setCreateTime( dto.getCreateTime() );
        videoToLabelVO.setUpdateBy( dto.getUpdateBy() );
        videoToLabelVO.setUpdateTime( dto.getUpdateTime() );
        videoToLabelVO.setRemark( dto.getRemark() );
        videoToLabelVO.setVideoId( dto.getVideoId() );
        videoToLabelVO.setLabelId( dto.getLabelId() );

        return videoToLabelVO;
    }

    @Override
    public List<VideoToLabelEntity> addDTO2EntityList(List<VideoToLabelAddDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoToLabelEntity> list1 = new ArrayList<VideoToLabelEntity>( list.size() );
        for ( VideoToLabelAddDTO videoToLabelAddDTO : list ) {
            list1.add( addDTO2Entity( videoToLabelAddDTO ) );
        }

        return list1;
    }
}
