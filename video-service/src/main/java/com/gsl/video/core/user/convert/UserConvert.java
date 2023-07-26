package com.gsl.video.core.user.convert;

import com.gsl.common.entity.BaseEntity;
import com.gsl.common.vo.BaseVO;
import com.gsl.video.core.user.dto.UserAddDTO;
import com.gsl.video.core.user.dto.UserReqDTO;
import com.gsl.video.core.user.entity.UserEntity;
import com.gsl.video.core.user.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", imports = {BaseEntity.class, BaseVO.class})
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /**
     * Entity 转 VO
     *
     * @param list 参数
     * @return list
     */
    List<UserVO> entity2VOList(List<UserEntity> list);

    /**
     * 新增DTO 转 Entity
     *
     * @param dto 参数
     * @return Entity
     */
    UserEntity addDTO2Entity(UserAddDTO dto);

    /**
     * 查询、修改 DTO 转 Entity
     *
     * @param dto 参数
     * @return Entity
     */
    UserEntity reqDTO2Entity(UserReqDTO dto);

    /**
     * Entity 转 VO
     *
     * @param dto 参数
     * @return Entity
     */
    UserVO entity2VO(UserEntity dto);

    /**
     * 新增DTO 转 Entity
     *
     * @param list 参数
     * @return Entity
     */
    List<UserEntity> addDTO2EntityList(List<UserAddDTO> list);
}
