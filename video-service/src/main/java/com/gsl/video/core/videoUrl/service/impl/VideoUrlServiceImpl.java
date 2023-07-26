package com.gsl.video.core.videoUrl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsl.video.core.videoUrl.entity.VideoUrlEntity;
import com.gsl.video.core.videoUrl.mapper.VideoUrlMapper;
import com.gsl.video.core.videoUrl.service.VideoUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 视频url信息Service实现类
 * @author system
 * @date 2023-05-22 10:09:40
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class VideoUrlServiceImpl extends ServiceImpl<VideoUrlMapper, VideoUrlEntity> implements VideoUrlService {

}
