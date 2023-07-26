package com.gsl.video.core.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsl.video.core.video.dto.VideoAddDTO;
import com.gsl.video.core.video.dto.VideoReqDTO;
import com.gsl.video.core.video.entity.VideoEntity;
import com.gsl.video.core.video.vo.VideoHomePageCareerVO;
import com.gsl.video.core.video.vo.VideoVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 视频 Service类
 * @author system
 */
public interface VideoService extends IService<VideoEntity> {

	/**
	 * 获取列表（分页）
	 * @param dto 请求参数
	 * @return 列表
	 */
	PageInfo<VideoVO> list(VideoReqDTO dto);

	/**
	 * @description 根据ids获取视频列表
	 * @author taojirun
	 * @date 16:05 2023/5/17
	 * @param ids
	 **/
	List<VideoVO> getListByIds(List<String> ids);

	/**
	 * 根据id获取
	 *
	 * @param id 主键
	 * @return VideoVO
	 */
	VideoVO get(String id);

	/**
	 * 新增
	 * @param dto 参数
	 * @return true/false
	 */
	boolean add(VideoAddDTO dto);

	/**
	 * 更新
	 * @param dto 参数
	 * @return true/false
	 */
	boolean update(VideoReqDTO dto);

	/**
	 * 根据ids删除
	 * @param ids 主键
	 * @return true/false
	 */
	boolean delete(List<String> ids);

	/**
	 * @param isAdd
	 * @return Long  更新后的用户操作（点赞、分享、点击...）数量
	 * @description
	 * @author taojirun
	 * @date 17:46 2023/5/12
	 **/
	Integer updateUserAction(String optionType, Boolean isAdd, String videoId);

	/**
	 * 批量插入
	 * @param dtos 对象
	 * @return true/false
	 */
	boolean batch(List<VideoAddDTO> dtos);

	/**
	 * 获取首页事业线视频列表
	 * @param dto
	 * @return 事业线视频列表
	 */
	VideoHomePageCareerVO getHomePageCareerList(VideoReqDTO dto);

}
