package com.gsl.video.core.user.controller;

import com.gsl.common.result.ResponseResult;
import com.gsl.video.core.user.dto.UserAddDTO;
import com.gsl.video.core.user.dto.UserReqDTO;
import com.gsl.video.core.user.service.UserService;
import com.gsl.video.core.user.vo.UserVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jodd.util.StringPool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;

/**
 * 控制层
 *
 * @author system
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户服务接口")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 获取列表（分页）
     *
     * @author system
     */
    @ApiOperation("获取列表（分页）")
    @GetMapping("/list")
    @ResponseResult
    public PageInfo<UserVO> list(UserReqDTO dto) {
        return userService.list(dto);
    }

    /**
     * 新增
     *
     * @author system
     */
    @ApiOperation("新增")
    @PostMapping("/add")
    @ResponseResult
    public Boolean add(@RequestBody @Valid UserAddDTO dto) {
        return userService.add(dto);
    }

    /**
     * 修改
     *
     * @author system
     */
    @ApiOperation(value = "修改")
    @PutMapping("/update")
    @ResponseResult
    public Boolean update(@RequestBody @Valid UserReqDTO dto) {
        return userService.update(dto);
    }

    /**
     * 根据id删除
     *
     * @author system
     */
    @ApiOperation(value = "根据id删除")
    @DeleteMapping("/delete/{ids}")
    @ResponseResult
    public Boolean delete(@PathVariable("ids") @NotEmpty String ids) {
        List<String> collect = Arrays.asList(StringUtils.split(ids, StringPool.COMMA));
        return userService.delete(collect);
    }

    /**
     * 根据id获取
     *
     * @author system
     */
    @ApiOperation(value = "根据id获取")
    @GetMapping(value = "/get/{id}")
    @ResponseResult
    public UserVO get(@PathVariable("id") @NotEmpty Long id) {
        return userService.get(id);
    }

}
