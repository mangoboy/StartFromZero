package com.gsl.video.core.video.controller;

import com.gsl.common.result.ResponseResult;
import com.gsl.video.core.video.constants.ExtOptionTypeConstants;
import com.gsl.video.core.video.dto.VideoAddDTO;
import com.gsl.video.core.video.dto.VideoClickDTO;
import com.gsl.video.core.video.dto.VideoOptionDTO;
import com.gsl.video.core.video.dto.VideoReqDTO;
import com.gsl.video.core.video.service.VideoService;
import com.gsl.video.core.video.vo.VideoHomePageCareerVO;
import com.gsl.video.core.video.vo.VideoVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jodd.util.StringPool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
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
@RequestMapping("/video")
@Api(tags = "视频服务接口")
public class VideoController {

    @Resource
    private VideoService videoService;

    /**
     * 获取列表（分页）
     *
     * @author system
     */
    @ApiOperation("获取列表（分页）")
    @GetMapping("/list")
    @ResponseResult
    public PageInfo<VideoVO> list(VideoReqDTO dto) {
        return videoService.list(dto);
    }

    /**
     * 根据ids获取视频列表
     *
     * @author system
     */
    @ApiOperation(value = "根据ids获取视频列表", hidden = true)
    @PostMapping("/getListByIds")
    @ResponseResult
    public List<VideoVO> getListByIds(@RequestBody List<String> ids) {
        return videoService.getListByIds(ids);
    }

    /**
     * 新增
     *
     * @author system
     */
    @ApiOperation("新增")
    @PostMapping("/add")
    @ResponseResult
    public Boolean add(@RequestBody @Valid VideoAddDTO dto) {
        return videoService.add(dto);
    }

    /**
     * 修改
     *
     * @author system
     */
    @ApiOperation(value = "修改")
    @PutMapping("/update")
    @ResponseResult
    public Boolean update(@RequestBody @Valid VideoReqDTO dto) {
        Assert.isTrue(StringUtils.isNotBlank(dto.getId()), "id不能为空");
        return videoService.update(dto);
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
        return videoService.delete(collect);
    }

    /**
     * 根据id获取
     *
     * @author system
     */
    @ApiOperation(value = "根据id获取")
    @GetMapping(value = "/get/{id}")
    @ResponseResult
    public VideoVO get(@PathVariable("id") @NotEmpty String id) {
        return videoService.get(id);
    }

    @ApiOperation("视频点击")
    @PutMapping("/click")
    @ResponseResult
    public Integer click(@RequestBody @Valid VideoClickDTO dto) {
        return videoService.updateUserAction(ExtOptionTypeConstants.CLICK, true, dto.getVideoId());
    }

    /**
     * #该接口不对前端开放#
     * 点赞、点击、收藏量操作
     *
     * @author system
     */
    @PutMapping("/updateUserAction")
    @ApiOperation(value = "", hidden = true)
    @ResponseResult
    public Integer userActionOption(@RequestBody @Valid VideoOptionDTO dto) {
        return videoService.updateUserAction(dto.getOptionType(), dto.getIsAdd(), dto.getVideoId());
    }

    /**
     * 获取首页事业线视频列表
     *
     * @author gsl
     */
    @ApiOperation("获取首页事业线视频列表")
    @GetMapping("/getHomePageCareerList")
    @ResponseResult
    public VideoHomePageCareerVO getHomePageCareerList(VideoReqDTO dto) {
        return videoService.getHomePageCareerList(dto);
    }

}
