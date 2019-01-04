package xyz.yzblog.base.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import xyz.yzblog.base.dataobject.Label;
import xyz.yzblog.base.form.LabelForm;
import xyz.yzblog.base.service.LabelService;
import xyz.yzblog.common.consts.StatusCode;
import xyz.yzblog.common.enums.StatusCodeEnum;
import xyz.yzblog.common.utils.ResultUtils;
import xyz.yzblog.common.vo.ResultVO;

@Api(description="标签服务")
@RestController
@RequestMapping("/label")
public class LabelController {
	
	@Autowired
	private LabelService labelService;
	
	@ApiOperation(value="查询标签",notes="查询所有标签列表")
	@GetMapping
	public ResultVO findAll(){
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, labelService.findAll());
	}
	
	@ApiOperation(value="查询单个标签",notes="根据ID查询标签")
	@ApiImplicitParam(paramType="path", name = "id", value = "标签ID", required = true, dataType = "String")
	@GetMapping("/{id}")
	public ResultVO findById(@PathVariable String id) {
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, labelService.findById(id));
	}
	
	@ApiOperation(value="新增标签",notes="增加标签")
	@ApiImplicitParams({
		@ApiImplicitParam(name="labelname",value="标签名称",dataType="String"),
		@ApiImplicitParam(name="state",value="状态(0 / 1)",dataType="String"),
		@ApiImplicitParam(name="recommend",value="是否推荐(Y / N)",dataType="String")
	})
	@PostMapping
	public ResultVO addLabel(@Valid LabelForm form, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResultVO(true, StatusCode.ERROR, bindingResult.getFieldError().getDefaultMessage());
		}
		Label label = new Label();
		BeanUtils.copyProperties(form, label);
		
		labelService.add(label);
		return ResultUtils.success(StatusCodeEnum.ADD_OK);
	}
	
	@ApiOperation(value="更新标签",notes="根据ID更新标签信息")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="path", name = "id", value = "标签ID", required = true, dataType = "String"),
		@ApiImplicitParam(paramType="body", name="from",value="标签实体",dataType="LabelForm"),
	})
	@PutMapping("/{id}")
	public ResultVO update(@RequestBody LabelForm from, @PathVariable String id) {
		
		Label label = new Label();
		BeanUtils.copyProperties(from, label);
		
		label.setId(id);
		labelService.update(label);
		return ResultUtils.success(StatusCodeEnum.UPDATE_OK);
	}
	
	@ApiOperation(value="删除单个标签",notes="根据ID删除标签")
	@ApiImplicitParam(paramType="path", name = "id", value = "标签ID", required = true, dataType = "String")
	@DeleteMapping("/{id}")
	public ResultVO delete(@PathVariable String id) {
		labelService.deleteById(id);
		return ResultUtils.success(StatusCodeEnum.DELETE_OK);
	}
	
	@ApiOperation(value="根据条件查询标签",notes="根据标签名称(labelname)、状态(state)、是否推荐(recommend)多个条件查询标签")
	@ApiImplicitParam(paramType="body", name="searchMap",value="标签实体",dataType="LabelForm")
	@PostMapping("/search")
	public ResultVO findSearch(@RequestBody Map<String, String> searchMap) {
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, labelService.findSearch(searchMap));
	}
}
