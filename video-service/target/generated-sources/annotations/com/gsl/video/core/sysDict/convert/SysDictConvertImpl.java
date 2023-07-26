package com.gsl.video.core.sysDict.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.sysDict.dto.SysDictAddDTO;
import com.gsl.video.core.sysDict.dto.SysDictReqDTO;
import com.gsl.video.core.sysDict.entity.SysDictEntity;
import com.gsl.video.core.sysDict.vo.SysDictVO;
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
public class SysDictConvertImpl implements SysDictConvert {

    @Override
    public List<SysDictVO> entity2VOList(List<SysDictEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysDictVO> list1 = new ArrayList<SysDictVO>( list.size() );
        for ( SysDictEntity sysDictEntity : list ) {
            list1.add( entity2VO( sysDictEntity ) );
        }

        return list1;
    }

    @Override
    public SysDictEntity addDTO2Entity(SysDictAddDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SysDictEntity sysDictEntity = new SysDictEntity();

        sysDictEntity.setLabel( dto.getLabel() );
        sysDictEntity.setValue( dto.getValue() );
        sysDictEntity.setType( dto.getType() );
        sysDictEntity.setStatus( dto.getStatus() );
        sysDictEntity.setSort( dto.getSort() );

        return sysDictEntity;
    }

    @Override
    public SysDictEntity reqDTO2Entity(SysDictReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SysDictEntity sysDictEntity = new SysDictEntity();

        sysDictEntity.setId( dto.getId() );
        sysDictEntity.setRemark( dto.getRemark() );
        sysDictEntity.setLabel( dto.getLabel() );
        sysDictEntity.setValue( dto.getValue() );
        sysDictEntity.setType( dto.getType() );
        sysDictEntity.setStatus( dto.getStatus() );
        sysDictEntity.setSort( dto.getSort() );

        return sysDictEntity;
    }

    @Override
    public SysDictVO entity2VO(SysDictEntity dto) {
        if ( dto == null ) {
            return null;
        }

        SysDictVO sysDictVO = new SysDictVO();

        sysDictVO.setId( dto.getId() );
        sysDictVO.setCreateBy( dto.getCreateBy() );
        sysDictVO.setCreateTime( dto.getCreateTime() );
        sysDictVO.setUpdateBy( dto.getUpdateBy() );
        sysDictVO.setUpdateTime( dto.getUpdateTime() );
        sysDictVO.setRemark( dto.getRemark() );
        sysDictVO.setLabel( dto.getLabel() );
        sysDictVO.setValue( dto.getValue() );
        sysDictVO.setType( dto.getType() );
        sysDictVO.setStatus( dto.getStatus() );
        sysDictVO.setSort( dto.getSort() );

        return sysDictVO;
    }

    @Override
    public List<SysDictEntity> addDTO2EntityList(List<SysDictAddDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SysDictEntity> list1 = new ArrayList<SysDictEntity>( list.size() );
        for ( SysDictAddDTO sysDictAddDTO : list ) {
            list1.add( addDTO2Entity( sysDictAddDTO ) );
        }

        return list1;
    }
}
