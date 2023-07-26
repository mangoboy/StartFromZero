package com.gsl.video.core.sysDict.controller;

import com.gsl.common.result.ResponseResult;
import com.gsl.video.core.sysDict.dto.SysDictAddDTO;
import com.gsl.video.core.sysDict.dto.SysDictReqDTO;
import com.gsl.video.core.sysDict.service.SysDictService;
import com.gsl.video.core.sysDict.vo.SysDictVO;
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
 * 系统字典控制层
 * @author taojirun
 * @since 2023-05-23 14:16:50
 */
@RestController
@RequestMapping("/sysDict")
@Api(tags = "系统字典")
public class SysDictController {

	@Resource
	private SysDictService sysDictService;
	
	/**
	 * 获取列表（分页）
	 * @author taojirun
	 */
	@ApiOperation("获取列表（分页）")
	@GetMapping("/list")
	@ResponseResult
	public PageInfo<SysDictVO> list(SysDictReqDTO dto) {
		return sysDictService.list(dto);
	}

	/**
	 * 新增
	 * @author taojirun
	 */
	@ApiOperation("新增")
	@PostMapping("/add")
	@ResponseResult
	public Boolean add(@RequestBody @Valid SysDictAddDTO dto) {
		return sysDictService.add(dto);
	}

	/**
	 * 修改
	 * @author taojirun
	 */
	@ApiOperation(value = "修改")
	@PutMapping("/update")
	@ResponseResult
	public Boolean update(@RequestBody @Valid SysDictReqDTO dto) {
		return sysDictService.update(dto);
	}

	/**
	 * 根据id删除
	 * @author taojirun
	 */
	@ApiOperation(value = "根据id删除")
	@DeleteMapping("/delete/{ids}")
	@ResponseResult
	public Boolean delete(@PathVariable("ids") @NotEmpty String ids) {
		List<String> collect = Arrays.asList(StringUtils.split(ids, StringPool.COMMA));
		return sysDictService.delete(collect);
	}

	/**
	 * 根据id获取明细
	 * @author taojirun
	 */
	@ApiOperation(value = "根据id获取明细")
	@GetMapping(value = "/get/{id}")
	@ResponseResult
	public SysDictVO get(@PathVariable("id") @NotEmpty Long id) {
		return sysDictService.get(id);
	}

}
