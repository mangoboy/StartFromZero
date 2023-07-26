package com.gsl.video.core.videoLabel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsl.video.core.videoLabel.dto.VideoLabelAddDTO;
import com.gsl.video.core.videoLabel.dto.VideoLabelReqDTO;
import com.gsl.video.core.videoLabel.entity.VideoLabelEntity;
import com.gsl.video.core.videoLabel.vo.VideoLabelVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 视频标签 Service类
 *
 * @author system
 * @date 2023-05-24 10:51:42
 */
public interface VideoLabelService extends IService<VideoLabelEntity> {

    /**
     * 获取列表（分页）
     *
     * @param dto 请求参数
     * @return 列表
     */
    PageInfo<VideoLabelVO> list(VideoLabelReqDTO dto);

    /**
     * 新增
     *
     * @param dto 参数
     * @return true/false
     */
    boolean add(VideoLabelAddDTO dto);

    /**
     * 更新
     *
     * @param dto 参数
     * @return true/false
     */
    boolean update(VideoLabelReqDTO dto);

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
     * @return VideoLabelVO
     */
    VideoLabelVO get(Long id);

    /**
     * 批量插入
     *
     * @param dtos 对象
     * @return true/false
     */
    boolean batch(List<VideoLabelAddDTO> dtos);

}
