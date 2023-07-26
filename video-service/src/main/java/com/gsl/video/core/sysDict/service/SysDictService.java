package com.gsl.video.core.sysDict.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsl.video.core.sysDict.dto.SysDictAddDTO;
import com.gsl.video.core.sysDict.dto.SysDictReqDTO;
import com.gsl.video.core.sysDict.entity.SysDictEntity;
import com.gsl.video.core.sysDict.vo.SysDictVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 系统字典 Service类
 * @author taojirun
 * @date 2023-05-23 14:16:50
 */
public interface SysDictService extends IService<SysDictEntity> {

	/**
	 * 获取列表（分页）
	 * @param dto 请求参数
	 * @return 列表
	 */
	PageInfo<SysDictVO> list(SysDictReqDTO dto);

	/**
	 * 获取列表（根据类型）
	 * @param type
	 * @return 列表
	 */
	List<SysDictVO> getListByType(String type);

	/**
	 * 新增
	 * @param dto 参数
	 * @return true/false
	 */
	boolean add(SysDictAddDTO dto);

	/**
	 * 更新
	 * @param dto 参数
	 * @return true/false
	 */
	boolean update(SysDictReqDTO dto);

	/**
	 * 根据ids删除
	 * @param ids 主键
	 * @return true/false
	 */
	boolean delete(List<String> ids);

	/**
	 * 根据id获取
	 *
	 * @param id 主键
	 * @return SysDictVO
	 */
	SysDictVO get(Long id);

	/**
	 * 批量插入
	 * @param dtos 对象
	 * @return true/false
	 */
	boolean batch(List<SysDictAddDTO> dtos);

}
