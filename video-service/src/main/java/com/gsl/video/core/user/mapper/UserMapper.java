package com.gsl.video.core.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsl.video.core.user.dto.UserReqDTO;
import com.gsl.video.core.user.entity.UserEntity;

import java.util.List;

/**
 * User Mapper类
 * @author system
 */
public interface UserMapper extends BaseMapper<UserEntity> {

	/**
	 * 获取列表
	 * @param dto 参数
	 * @return 列表
	 */
	List<UserEntity> getList(UserReqDTO dto);

}
