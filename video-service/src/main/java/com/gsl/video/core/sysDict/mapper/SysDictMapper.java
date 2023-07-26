package com.gsl.video.core.sysDict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsl.video.core.sysDict.dto.SysDictReqDTO;
import com.gsl.video.core.sysDict.entity.SysDictEntity;

import java.util.List;

/**
 * 系统字典 Mapper类
 * @author taojirun
 * @date 2023-05-23 14:16:50
 */
public interface SysDictMapper extends BaseMapper<SysDictEntity> {

	/**
	 * 获取列表
	 * @param dto 参数
	 * @return 列表
	 */
	List<SysDictEntity> getList(SysDictReqDTO dto);

}
