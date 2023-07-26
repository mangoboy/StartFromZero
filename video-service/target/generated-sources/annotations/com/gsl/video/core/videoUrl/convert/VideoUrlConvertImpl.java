package com.gsl.video.core.videoUrl.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.videoUrl.dto.VideoUrlAddDTO;
import com.gsl.video.core.videoUrl.dto.VideoUrlReqDTO;
import com.gsl.video.core.videoUrl.entity.VideoUrlEntity;
import com.gsl.video.core.videoUrl.vo.VideoUrlVO;
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
public class VideoUrlConvertImpl implements VideoUrlConvert {

    @Override
    public List<VideoUrlVO> entity2VOList(List<VideoUrlEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoUrlVO> list1 = new ArrayList<VideoUrlVO>( list.size() );
        for ( VideoUrlEntity videoUrlEntity : list ) {
            list1.add( entity2VO( videoUrlEntity ) );
        }

        return list1;
    }

    @Override
    public VideoUrlEntity addDTO2Entity(VideoUrlAddDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VideoUrlEntity videoUrlEntity = new VideoUrlEntity();

        videoUrlEntity.setUrl( dto.getUrl() );
        videoUrlEntity.setStreamType( dto.getStreamType() );
        videoUrlEntity.setResolution( dto.getResolution() );

        return videoUrlEntity;
    }

    @Override
    public VideoUrlEntity reqDTO2Entity(VideoUrlReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VideoUrlEntity videoUrlEntity = new VideoUrlEntity();

        videoUrlEntity.setId( dto.getId() );
        videoUrlEntity.setRemark( dto.getRemark() );
        videoUrlEntity.setUrl( dto.getUrl() );
        videoUrlEntity.setStreamType( dto.getStreamType() );
        videoUrlEntity.setResolution( dto.getResolution() );

        return videoUrlEntity;
    }

    @Override
    public VideoUrlVO entity2VO(VideoUrlEntity dto) {
        if ( dto == null ) {
            return null;
        }

        VideoUrlVO videoUrlVO = new VideoUrlVO();

        videoUrlVO.setUrl( dto.getUrl() );
        videoUrlVO.setStreamType( dto.getStreamType() );
        videoUrlVO.setResolution( dto.getResolution() );

        return videoUrlVO;
    }

    @Override
    public List<VideoUrlEntity> addDTO2EntityList(List<VideoUrlAddDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoUrlEntity> list1 = new ArrayList<VideoUrlEntity>( list.size() );
        for ( VideoUrlAddDTO videoUrlAddDTO : list ) {
            list1.add( addDTO2Entity( videoUrlAddDTO ) );
        }

        return list1;
    }
}
