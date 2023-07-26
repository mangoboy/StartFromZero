package com.gsl.video.core.video.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsl.common.exception.CustomException;
import com.gsl.common.utils.PageUtil;
import com.gsl.video.core.careerLine.dto.CareerLineReqDTO;
import com.gsl.video.core.careerLine.service.CareerLineService;
import com.gsl.video.core.careerLine.vo.CareerLineVO;
import com.gsl.video.core.sysDict.constants.SysDictTypeConstants;
import com.gsl.video.core.sysDict.service.SysDictService;
import com.gsl.video.core.sysDict.vo.SysDictVO;
import com.gsl.video.core.video.constants.BusiTypeConstants;
import com.gsl.video.core.video.constants.ExtOptionTypeConstants;
import com.gsl.video.core.video.convert.VideoConvert;
import com.gsl.video.core.video.convert.VideoExtConvert;
import com.gsl.video.core.video.dto.VideoAddDTO;
import com.gsl.video.core.video.dto.VideoReqDTO;
import com.gsl.video.core.video.entity.VideoEntity;
import com.gsl.video.core.video.entity.VideoExtEntity;
import com.gsl.video.core.video.mapper.VideoExtMapper;
import com.gsl.video.core.video.mapper.VideoMapper;
import com.gsl.video.core.video.service.VideoService;
import com.gsl.video.core.video.vo.VideoHomePageCareerVO;
import com.gsl.video.core.video.vo.VideoVO;
import com.gsl.video.core.videoLabel.entity.VideoLabelEntity;
import com.gsl.video.core.videoLabel.mapper.VideoLabelMapper;
import com.gsl.video.core.videoLabel.service.VideoLabelService;
import com.gsl.video.core.videoLabel.vo.VideoLabelVO;
import com.gsl.video.core.videoToLabel.entity.VideoToLabelEntity;
import com.gsl.video.core.videoToLabel.service.VideoToLabelService;
import com.gsl.video.core.videoUrl.convert.VideoUrlConvert;
import com.gsl.video.core.videoUrl.entity.VideoUrlEntity;
import com.gsl.video.core.videoUrl.mapper.VideoUrlMapper;
import com.gsl.video.core.videoUrl.service.VideoUrlService;
import com.gsl.video.core.videoUrl.vo.VideoUrlVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service实现类
 *
 * @author system
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class VideoServiceImpl extends ServiceImpl<VideoMapper, VideoEntity> implements VideoService {

    @Value("${vp.dp.host}")
    private String dpHost;

    @Resource
    private VideoMapper videoMapper;
    @Resource
    private VideoExtMapper videoExtMapper;
    @Resource
    private VideoUrlMapper videoUrlMapper;
    @Resource
    private VideoLabelMapper videoLabelMapper;

    @Resource
    private VideoConvert videoConvert;
    @Resource
    private VideoExtConvert videoExtConvert;
    @Resource
    private VideoUrlConvert videoUrlConvert;

    @Resource
    private VideoUrlService videoUrlService;
    @Resource
    private CareerLineService careerLineService;
    @Resource
    private SysDictService sysDictService;
    @Resource
    private VideoLabelService videoLabelService;
    @Resource
    private VideoToLabelService videoToLabelService;


    @Override
    public PageInfo<VideoVO> list(VideoReqDTO dto) {
        PageUtil.startPage(dto);
        VideoEntity entity = VideoConvert.INSTANCE.reqDTO2Entity(dto);
        LambdaQueryWrapper<VideoEntity> wrapper = Wrappers.lambdaQuery(entity);
        wrapper.orderByDesc(VideoEntity::getId);
        List<VideoEntity> list = list(wrapper);
        List<VideoVO> voList = VideoConvert.INSTANCE.entity2VOList(list);
        packVOList(voList);
        return PageUtil.page(list, voList);
    }


    @Override
    public List<VideoVO> getListByIds(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.EMPTY_LIST;
        }
        LambdaQueryWrapper<VideoEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.in(VideoEntity::getId, ids);
        List<VideoEntity> list = videoMapper.selectList(wrapper);
        List<VideoVO> voList = videoConvert.entity2VOList(list);
        packVOList(voList);
        return voList;
    }

    /**
     * @param voList
     * @return void
     * @description 设置点赞量、标签、事业线等属性
     * @author taojirun
     * @date 17:06 2023/5/24
     **/
    private void packVOList(List<VideoVO> voList) {
        if (CollUtil.isNotEmpty(voList)) {
            List<String> videoIdList = voList.stream().map(VideoVO::getId).collect(Collectors.toList());
            //ext表
            LambdaQueryWrapper<VideoExtEntity> extWrapper = new LambdaQueryWrapper<>();
            extWrapper.in(VideoExtEntity::getVideoId, videoIdList)
                    .orderByDesc(VideoExtEntity::getVideoId);
            List<VideoExtEntity> extEntityList = videoExtMapper.selectList(extWrapper);
            //事业线
            Map<String, List<SysDictVO>> dictGroup = sysDictService.getListByType(SysDictTypeConstants.CAREER_LINE).stream().collect(Collectors.groupingBy(SysDictVO::getLabel));
            //标签
            Map<String, List<VideoLabelVO>> labelGroup = videoLabelMapper.getListByVideoIds(videoIdList).stream().collect(Collectors.groupingBy(VideoLabelVO::getVideoId));
            for (int i = 0; i < voList.size(); i++) {
                VideoVO videoVO = voList.get(i);
                //ext表 点赞、点击...
                setExtVO(videoVO, extEntityList.get(i));
                //事业线
                String careerLineVal = CollUtil.isEmpty(dictGroup.get(videoVO.getCareerLine()))
                        ? null : dictGroup.get(videoVO.getCareerLine()).get(0).getValue();
                videoVO.setCareerLineVal(careerLineVal);
                //标签
                List<VideoLabelVO> labelVOList = labelGroup.get(videoVO.getId());
                List<String> label =  CollectionUtil.isNotEmpty(labelVOList) ?
                        labelVOList.stream().map(VideoLabelVO::getName).collect(Collectors.toList())
                        : Collections.EMPTY_LIST;
                videoVO.setLabelList(label);
            }
        }
    }

    @Override
    @Transactional(readOnly = false)
    public VideoVO get(String id) {
        VideoEntity entity = getById(id);
        VideoVO vo = VideoConvert.INSTANCE.entity2VO(entity);
        if (entity == null) {
            return new VideoVO();
        }
        //ext表
        LambdaQueryWrapper<VideoExtEntity> extWrapper = new LambdaQueryWrapper<>();
        extWrapper.eq(VideoExtEntity::getVideoId, id);
        VideoExtEntity extEntity = videoExtMapper.selectOne(extWrapper);
        setExtVO(vo, extEntity);
        //视频url表
        LambdaQueryWrapper<VideoUrlEntity> urlWrappers = new LambdaQueryWrapper<>();
        urlWrappers.eq(VideoUrlEntity::getVideoId, id);
        List<VideoUrlEntity> urlEntityList = videoUrlMapper.selectList(urlWrappers);
        List<VideoUrlVO> urlVOList = videoUrlConvert.entity2VOList(urlEntityList);
        urlVOList = Optional.ofNullable(urlVOList).orElse(Collections.EMPTY_LIST);
        vo.setUrlList(urlVOList);
        if (entity.getBusiType() == BusiTypeConstants.EXTERNAL_LINK) {
            urlVOList.forEach(item -> {
                // 为 “/”开头的url 跳转外部链接 加上 host
                if (StringUtils.startsWith(item.getUrl(), StringPool.SLASH)) {
                    item.setUrl(dpHost + item.getUrl());
                }
            });
        }
        //标签
        List<String> labelList = videoLabelMapper.getListByVideoIds(Arrays.asList(id)).stream().map(VideoLabelVO::getName).collect(Collectors.toList());
        vo.setLabelList(labelList);
        //点击量+1
        addClick(id);
        return vo;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public boolean add(VideoAddDTO dto) {
        VideoEntity entity = VideoConvert.INSTANCE.addDTO2Entity(dto);
        //主表
        boolean save = save(entity);
        //扩展表
        VideoExtEntity extEntity = new VideoExtEntity();
        extEntity.setVideoId(entity.getId());
        videoExtMapper.insert(extEntity);
        //url表
        List<VideoUrlEntity> urlETList = videoUrlConvert.addDTO2EntityList(dto.getUrlList());
        urlETList.forEach(item -> item.setVideoId(entity.getId()));
        videoUrlService.saveBatch(urlETList);
        //标签
        addOrUpdateLabel(dto.getLabelList(), entity.getId());
        return save;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public boolean update(VideoReqDTO dto) {
        VideoEntity entity = VideoConvert.INSTANCE.reqDTO2Entity(dto);
        boolean b = updateById(entity);
        //url表
        LambdaUpdateWrapper<VideoUrlEntity> urlWrappers = new LambdaUpdateWrapper<>();
        urlWrappers.eq(VideoUrlEntity::getVideoId, dto.getId());
        videoUrlMapper.delete(urlWrappers);
        List<VideoUrlEntity> urlETList = videoUrlConvert.addDTO2EntityList(dto.getUrlList());
        urlETList.forEach(item -> item.setVideoId(entity.getId()));
        videoUrlService.saveBatch(urlETList);
        //标签
        addOrUpdateLabel(dto.getLabelList(), entity.getId());
        return b;
    }

    @Transactional(rollbackFor = {Exception.class, Error.class})
    @Override
    public boolean delete(List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            log.error("【删除失败】参数为空！");
            return false;
        }
        boolean b = removeByIds(ids);
        //ext表
        LambdaUpdateWrapper<VideoExtEntity> extWrapper = new LambdaUpdateWrapper<>();
        extWrapper.in(VideoExtEntity::getVideoId, ids);
        videoExtMapper.delete(extWrapper);
        //url表
        LambdaUpdateWrapper<VideoUrlEntity> urlWrapper = new LambdaUpdateWrapper<>();
        urlWrapper.in(VideoUrlEntity::getVideoId, ids);
        videoUrlMapper.delete(urlWrapper);
        //视频标签对应表
        LambdaUpdateWrapper<VideoToLabelEntity> labelWrapper = new LambdaUpdateWrapper<>();
        labelWrapper.in(VideoToLabelEntity::getVideoId, ids);
        videoToLabelService.remove(labelWrapper);
        return b;
    }

    /**
     * @param video
     * @return java.lang.Integer
     * @description 点击量+1
     * @author taojirun
     * @date 11:20 2023/5/24
     **/
    @Async
    public Integer addClick(String video) {
        return updateUserAction(ExtOptionTypeConstants.CLICK, true, video);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public Integer updateUserAction(String optionType, Boolean isAdd, String videoId) {
        Integer num = 0;
        LambdaQueryWrapper<VideoExtEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(VideoExtEntity::getVideoId, videoId);
        VideoExtEntity entity = videoExtMapper.selectOne(wrapper);
        if (entity == null) {
            throw new CustomException("视频不存在");
        }
        LambdaUpdateWrapper<VideoExtEntity> updateWrapper = new LambdaUpdateWrapper<>();
        VideoExtEntity updateExt = new VideoExtEntity();
        updateExt.setId(entity.getId());
        switch (optionType) {
            case ExtOptionTypeConstants.CLICK:
                updateExt.setClickNum(compute(isAdd, entity.getClickNum()));
                break;
            case ExtOptionTypeConstants.LIKE:
                //乐观锁
                updateWrapper.eq(VideoExtEntity::getLikeNum, entity.getLikeNum());
                updateExt.setLikeNum(compute(isAdd, entity.getLikeNum()));
                break;
            case ExtOptionTypeConstants.COLLECT:
                //乐观锁
                updateWrapper.eq(VideoExtEntity::getCollectNum, entity.getCollectNum());
                updateExt.setCollectNum(compute(isAdd, entity.getCollectNum()));
                break;
            case ExtOptionTypeConstants.SHARE:
                updateExt.setShareNum(compute(isAdd, entity.getShareNum()));
                break;
            default:
                log.error("操作类型不正确, 类型:{}", optionType);
                throw new CustomException("更新失败，请重试");
        }
        updateWrapper.eq(VideoExtEntity::getId, updateExt.getId());
        int update = videoExtMapper.update(updateExt, updateWrapper);
        if (update <= 0) {
            throw new CustomException("更新失败，请重试");
        }
        return num;
    }

    @Transactional(rollbackFor = {Exception.class, Error.class})
    @Override
    public boolean batch(List<VideoAddDTO> dtos) {
        List<VideoEntity> entityList = VideoConvert.INSTANCE.addDTO2EntityList(dtos);
        return saveBatch(entityList);
    }

    public VideoHomePageCareerVO getHomePageCareerList(VideoReqDTO dto) {
        VideoHomePageCareerVO result = new VideoHomePageCareerVO();
        List list = new ArrayList();
        //获取事业线
        List<CareerLineVO> careerLineVOS = careerLineService.listNoPage(new CareerLineReqDTO());
        if (!CollectionUtils.isEmpty(careerLineVOS)) {
            careerLineVOS.stream().forEach(careerLineVO -> {
                dto.setCareerLine(careerLineVO.getId());
                List<VideoVO> vos = videoMapper.getHomePageCareerList(dto);
                Optional.ofNullable(vos).orElse(Collections.EMPTY_LIST);
                Map temp = new HashMap();
                temp.put("careerId", careerLineVO.getId());
                temp.put("careerName", careerLineVO.getName());
                temp.put("data", vos);
                list.add(temp);
            });
        }
        result.setList(list);
        return result;
    }

    /**
     * @param isAdd
     * @param num
     * @return int
     * @description 计算 点赞、收藏、点击量
     * @author taojirun
     * @date 14:14 2023/5/19
     **/
    private int compute(boolean isAdd, int num) {
        if (isAdd) {
            return num + 1;
        }
        if (num <= 0) {
            return 0;
        }
        return num - 1;
    }

    /**
     * @param vo
     * @param videoExtVO
     * @return void
     * @description 设置点赞、收藏、点击量
     * @author taojirun
     * @date 14:28 2023/5/24
     **/
    private void setExtVO(VideoVO vo, VideoExtEntity videoExtVO) {
        vo.setClickNum(videoExtVO.getClickNum());
        vo.setCollectNum(videoExtVO.getCollectNum());
        vo.setLikeNum(videoExtVO.getLikeNum());
        vo.setShareNum(videoExtVO.getShareNum());
    }

    /**
     * 新增或更新标签
     *
     * @param labelList
     * @param videoId
     * @return
     */
    private Boolean addOrUpdateLabel(List<String> labelList, String videoId) {
        if (CollectionUtil.isEmpty(labelList) || StringUtils.isBlank(videoId)) {
            return false;
        }
        //标签表
        LambdaQueryWrapper<VideoLabelEntity> labelWrapper = new LambdaQueryWrapper<>();
        labelWrapper.in(VideoLabelEntity::getName, labelList);
        List<VideoLabelEntity> existLabelList = videoLabelMapper.selectList(labelWrapper);
        List<String> existLabelName = existLabelList.stream().map(VideoLabelEntity::getName).collect(Collectors.toList());
        List<VideoLabelEntity> addLabelList = new ArrayList<>();
        labelList.stream().distinct().forEach(name -> {
            if (!existLabelName.contains(name)) {
                VideoLabelEntity labelEntity = new VideoLabelEntity();
                addLabelList.add(labelEntity);
                labelEntity.setName(name);
            }
        });
        boolean b = videoLabelService.saveBatch(addLabelList);
        //视频-之前保存的标签
        List<VideoLabelVO> videoExistLabelVOs = videoLabelMapper.getListByVideoIds(Arrays.asList(videoId));
        List<String> videoExistLabels = videoExistLabelVOs.stream().map(VideoLabelVO::getName).collect(Collectors.toList());
        //视频-需要删除的标签id（视频-标签对应表id）
        List<String> videoDelLabelIds = videoExistLabelVOs.stream().filter(item -> !labelList.contains(item.getName())).map(VideoLabelVO::getToLabelId).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(videoDelLabelIds)) {
            LambdaUpdateWrapper<VideoToLabelEntity> toLabelWrapper = new LambdaUpdateWrapper<>();
            toLabelWrapper.in(VideoToLabelEntity::getId, videoDelLabelIds);
            videoToLabelService.remove(toLabelWrapper);
        }
        //视频-需要新增的标签
        List<String> videoAddLabels = labelList.stream().filter(item -> !videoExistLabels.contains(item)).collect(Collectors.toList());
        List<VideoToLabelEntity> videoToLabelEntities = new ArrayList<>(videoAddLabels.size());
        addLabelList.forEach(item -> {
            VideoToLabelEntity toLabelEntity = new VideoToLabelEntity();
            videoToLabelEntities.add(toLabelEntity);
            toLabelEntity.setVideoId(videoId);
            toLabelEntity.setLabelId(item.getId());
        });
        boolean b1 = videoToLabelService.saveBatch(videoToLabelEntities);
        return b && b1;
    }

}
