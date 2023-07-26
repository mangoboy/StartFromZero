package com.gsl.video.core.video.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.video.entity.VideoExtEntity;
import com.gsl.video.core.video.vo.VideoExtVO;
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
public class VideoExtConvertImpl implements VideoExtConvert {

    @Override
    public List<VideoExtVO> entity2VOList(List<VideoExtEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<VideoExtVO> list1 = new ArrayList<VideoExtVO>( list.size() );
        for ( VideoExtEntity videoExtEntity : list ) {
            list1.add( entity2VO( videoExtEntity ) );
        }

        return list1;
    }

    @Override
    public VideoExtVO entity2VO(VideoExtEntity dto) {
        if ( dto == null ) {
            return null;
        }

        VideoExtVO videoExtVO = new VideoExtVO();
        System.out.println("12212121");

        videoExtVO.setId( dto.getId() );
        videoExtVO.setCreateBy( dto.getCreateBy() );
        videoExtVO.setCreateTime( dto.getCreateTime() );
        videoExtVO.setUpdateBy( dto.getUpdateBy() );
        videoExtVO.setUpdateTime( dto.getUpdateTime() );
        videoExtVO.setRemark( dto.getRemark() );
        videoExtVO.setVideoId( dto.getVideoId() );
        videoExtVO.setClickNum( dto.getClickNum() );
        videoExtVO.setLikeNum( dto.getLikeNum() );
        videoExtVO.setCollectNum( dto.getCollectNum() );
        videoExtVO.setShareNum( dto.getShareNum() );

        return videoExtVO;
    }
}
