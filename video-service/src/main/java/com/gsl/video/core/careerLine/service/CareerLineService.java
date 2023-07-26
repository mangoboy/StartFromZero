package com.gsl.video.core.careerLine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsl.video.core.careerLine.dto.CareerLineAddDTO;
import com.gsl.video.core.careerLine.dto.CareerLineReqDTO;
import com.gsl.video.core.careerLine.entity.CareerLineEntity;
import com.gsl.video.core.careerLine.vo.CareerLineVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 事业线分类 Service类
 * @author system
 */
public interface CareerLineService extends IService<CareerLineEntity> {

	/**
	 * 获取列表（分页）
	 * @param dto 请求参数
	 * @return 列表
	 */
	PageInfo<CareerLineVO> list(CareerLineReqDTO dto);

	/**
	 * 新增
	 * @param dto 参数
	 * @return true/false
	 */
	boolean add(CareerLineAddDTO dto);

	/**
	 * 更新
	 * @param dto 参数
	 * @return true/false
	 */
	boolean update(CareerLineReqDTO dto);

	/**
	 * 根据ids删除
	 * @param ids 主键
	 * @return true/false
	 */
	boolean delete(List<Long> ids);

	/**
	 * 根据id获取
	 *
	 * @param id 主键
	 * @return CareerLineVO
	 */
	CareerLineVO get(Long id);

	/**
	 * 批量插入
	 * @param dtos 对象
	 * @return true/false
	 */
	boolean batch(List<CareerLineAddDTO> dtos);

	/**
	 * 获取列表
	 * @param dto 请求参数
	 * @return 列表
	 */
	List<CareerLineVO> listNoPage(CareerLineReqDTO dto);

}
