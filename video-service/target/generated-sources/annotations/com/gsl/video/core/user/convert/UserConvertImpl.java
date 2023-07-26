package com.gsl.video.core.user.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.user.dto.UserAddDTO;
import com.gsl.video.core.user.dto.UserReqDTO;
import com.gsl.video.core.user.entity.UserEntity;
import com.gsl.video.core.user.vo.UserVO;
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
public class UserConvertImpl implements UserConvert {

    @Override
    public List<UserVO> entity2VOList(List<UserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<UserVO> list1 = new ArrayList<UserVO>( list.size() );
        for ( UserEntity userEntity : list ) {
            list1.add( entity2VO( userEntity ) );
        }

        return list1;
    }

    @Override
    public UserEntity addDTO2Entity(UserAddDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId( dto.getUserId() );
        userEntity.setName( dto.getName() );
        userEntity.setNumber( dto.getNumber() );
        userEntity.setAmount( dto.getAmount() );
        userEntity.setQty( dto.getQty() );
        userEntity.setStatus( dto.getStatus() );

        return userEntity;
    }

    @Override
    public UserEntity reqDTO2Entity(UserReqDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( dto.getId() );
        userEntity.setRemark( dto.getRemark() );
        userEntity.setUserId( dto.getUserId() );
        userEntity.setName( dto.getName() );
        userEntity.setNumber( dto.getNumber() );
        userEntity.setAmount( dto.getAmount() );
        userEntity.setQty( dto.getQty() );
        userEntity.setStatus( dto.getStatus() );

        return userEntity;
    }

    @Override
    public UserVO entity2VO(UserEntity dto) {
        if ( dto == null ) {
            return null;
        }

        UserVO userVO = new UserVO();

        userVO.setId( dto.getId() );
        userVO.setCreateBy( dto.getCreateBy() );
        userVO.setCreateTime( dto.getCreateTime() );
        userVO.setUpdateBy( dto.getUpdateBy() );
        userVO.setUpdateTime( dto.getUpdateTime() );
        userVO.setRemark( dto.getRemark() );
        userVO.setUserId( dto.getUserId() );
        userVO.setName( dto.getName() );
        userVO.setNumber( dto.getNumber() );
        userVO.setAmount( dto.getAmount() );
        userVO.setQty( dto.getQty() );
        userVO.setStatus( dto.getStatus() );

        return userVO;
    }

    @Override
    public List<UserEntity> addDTO2EntityList(List<UserAddDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<UserEntity> list1 = new ArrayList<UserEntity>( list.size() );
        for ( UserAddDTO userAddDTO : list ) {
            list1.add( addDTO2Entity( userAddDTO ) );
        }

        return list1;
    }
}
