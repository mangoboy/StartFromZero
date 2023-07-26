package com.gsl.video.core.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsl.video.core.user.dto.UserAddDTO;
import com.gsl.video.core.user.dto.UserReqDTO;
import com.gsl.video.core.user.entity.UserEntity;
import com.gsl.video.core.user.vo.UserVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * User Service类
 *
 * @author system
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 获取列表（分页）
     *
     * @param dto 请求参数
     * @return 列表
     */
    PageInfo<UserVO> list(UserReqDTO dto);

    /**
     * 新增
     *
     * @param dto 参数
     * @return true/false
     */
    boolean add(UserAddDTO dto);

    /**
     * 更新
     *
     * @param dto 参数
     * @return true/false
     */
    boolean update(UserReqDTO dto);

    /**
     * 根据ids删除
     *
     * @param ids 主键
     * @return true/false
     */
    boolean delete(List<String> ids);

    /**
     * 根据id获取
     *
     * @param id 主键
     * @return UserVO
     */
    UserVO get(Long id);

    /**
     * 批量插入
     *
     * @param dtos 对象
     * @return true/false
     */
    boolean batch(List<UserAddDTO> dtos);

}
