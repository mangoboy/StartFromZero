package com.gsl.video.core.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsl.common.utils.PageUtil;
import com.gsl.video.core.user.convert.UserConvert;
import com.gsl.video.core.user.dto.UserAddDTO;
import com.gsl.video.core.user.dto.UserReqDTO;
import com.gsl.video.core.user.entity.UserEntity;
import com.gsl.video.core.user.mapper.UserMapper;
import com.gsl.video.core.user.service.UserService;
import com.gsl.video.core.user.vo.UserVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


/**
 * Service实现类
 *
 * @author system
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public PageInfo<UserVO> list(UserReqDTO dto) {
        PageUtil.startPage(dto);
        UserEntity entity = UserConvert.INSTANCE.reqDTO2Entity(dto);
        LambdaQueryWrapper<UserEntity> wrapper = Wrappers.lambdaQuery(entity);
        List<UserEntity> list = list(wrapper);
        List<UserVO> voList = UserConvert.INSTANCE.entity2VOList(list);
        return PageUtil.page(list, voList);
    }

    @Transactional(rollbackFor = {Exception.class, Error.class})
    @Override
    public boolean add(UserAddDTO dto) {
        UserEntity entity = UserConvert.INSTANCE.addDTO2Entity(dto);
        return save(entity);
    }

    @Transactional(rollbackFor = {Exception.class, Error.class})
    @Override
    public boolean update(UserReqDTO dto) {
        UserEntity entity = UserConvert.INSTANCE.reqDTO2Entity(dto);
        return updateById(entity);
    }

    @Transactional(rollbackFor = {Exception.class, Error.class})
    @Override
    public boolean delete(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            log.error("【删除失败】参数为空！");
            return false;
        }
        return removeByIds(ids);
    }

    @Override
    public UserVO get(Long id) {
        UserVO vo = UserConvert.INSTANCE.entity2VO(getById(id));
        return Optional.ofNullable(vo).orElse(new UserVO());
    }

    @Transactional(rollbackFor = {Exception.class, Error.class})
    @Override
    public boolean batch(List<UserAddDTO> dtos) {
        List<UserEntity> entityList = UserConvert.INSTANCE.addDTO2EntityList(dtos);
        return saveBatch(entityList);
    }
}
