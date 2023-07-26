package com.gsl.video.core.careerLine.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.careerLine.dto.CareerLineAddDTO;
import com.gsl.video.core.careerLine.dto.CareerLineReqDTO;
import com.gsl.video.core.careerLine.entity.CareerLineEntity;
import com.gsl.video.core.careerLine.vo.CareerLineVO;
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
public class CareerLineConvertImpl implements CareerLineConvert {

    @Override
    public List<CareerLineVO> entity2VOList(List<CareerLineEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CareerLineVO> list1 = new ArrayList<CareerLineVO>( list.size() );
        for ( CareerLineEntity careerLineEntity : list ) {
            list1.add( entity2VO( careerLineEntity ) );
        }

        return list1;
    }

    @Override
    public CareerLineEntity addDTO2Entity(CareerLineAddDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CareerLineEntity careerLineEntity = new CareerLineEntity();

        careerLineEntity.setName( dto.getName() );
        careerLineEntity.setNameEn( dto.getNameEn() );
        careerLineEntity.setSort( dto.getSort() );

        return careerLineEntity;
    }

    @Override
    public CareerLineEntity reqDTO2Entity(CareerLineReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CareerLineEntity careerLineEntity = new CareerLineEntity();

        careerLineEntity.setId( dto.getId() );
        careerLineEntity.setRemark( dto.getRemark() );
        careerLineEntity.setName( dto.getName() );
        careerLineEntity.setNameEn( dto.getNameEn() );
        careerLineEntity.setSort( dto.getSort() );

        return careerLineEntity;
    }

    @Override
    public CareerLineVO entity2VO(CareerLineEntity dto) {
        if ( dto == null ) {
            return null;
        }

        CareerLineVO careerLineVO = new CareerLineVO();

        careerLineVO.setId( dto.getId() );
        careerLineVO.setCreateBy( dto.getCreateBy() );
        careerLineVO.setCreateTime( dto.getCreateTime() );
        careerLineVO.setUpdateBy( dto.getUpdateBy() );
        careerLineVO.setUpdateTime( dto.getUpdateTime() );
        careerLineVO.setRemark( dto.getRemark() );
        careerLineVO.setName( dto.getName() );
        careerLineVO.setNameEn( dto.getNameEn() );
        careerLineVO.setSort( dto.getSort() );

        return careerLineVO;
    }

    @Override
    public List<CareerLineEntity> addDTO2EntityList(List<CareerLineAddDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<CareerLineEntity> list1 = new ArrayList<CareerLineEntity>( list.size() );
        for ( CareerLineAddDTO careerLineAddDTO : list ) {
            list1.add( addDTO2Entity( careerLineAddDTO ) );
        }

        return list1;
    }
}
