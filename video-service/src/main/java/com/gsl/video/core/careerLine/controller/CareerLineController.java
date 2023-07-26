package com.gsl.video.core.careerLine.controller;

import com.github.pagehelper.PageInfo;
import com.gsl.common.result.ResponseResult;
import com.gsl.video.core.careerLine.dto.CareerLineAddDTO;
import com.gsl.video.core.careerLine.dto.CareerLineReqDTO;
import com.gsl.video.core.careerLine.service.CareerLineService;
import com.gsl.video.core.careerLine.vo.CareerLineVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jodd.util.StringPool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 控制层
 * @author system
 */
@RestController
@RequestMapping("/careerline")
@Api(tags = "CareerLine服务接口")
public class CareerLineController {

	@Resource
	private CareerLineService careerLineService;

	/**
	 * 获取列表（分页）
	 * @author system
	 */
	@ApiOperation("获取列表（分页）")
	@GetMapping("/list")
	@ResponseResult
	public PageInfo<CareerLineVO> list(CareerLineReqDTO dto) {
		return careerLineService.list(dto);
	}

	/**
	 * 新增
	 * @author system
	 */
	@ApiOperation("新增")
	@PostMapping("/add")
	@ResponseResult
	public Boolean add(@RequestBody @Valid CareerLineAddDTO dto) {
		return careerLineService.add(dto);
	}

	/**
	 * 修改
	 * @author system
	 */
	@ApiOperation(value = "修改")
	@PutMapping("/update")
	@ResponseResult
	public Boolean update(@RequestBody @Valid CareerLineReqDTO dto) {
		return careerLineService.update(dto);
	}

	/**
	 * 根据id删除
	 * @author system
	 */
	@ApiOperation(value = "根据id删除")
	@DeleteMapping("/delete/{ids}")
	@ResponseResult
	public Boolean delete(@PathVariable("ids") @NotEmpty String ids) {
		List<Long> collect = Stream.of(StringUtils.split(ids, StringPool.COMMA)).map(Long::valueOf).collect(Collectors.toList());
		return careerLineService.delete(collect);
	}

	/**
	 * 根据id获取
	 * @author system
	 */
	@ApiOperation(value = "根据id获取")
	@GetMapping(value = "/get/{id}")
	@ResponseResult
	public CareerLineVO get(@PathVariable("id") @NotEmpty Long id) {
		return careerLineService.get(id);
	}

	/**
	 * 获取列表
	 * @author gsl
	 */
	@ApiOperation("获取列表")
	@GetMapping("/listNoPage")
	@ResponseResult
	public List<CareerLineVO> listNoPage(CareerLineReqDTO dto) {
		return careerLineService.listNoPage(dto);
	}

}
