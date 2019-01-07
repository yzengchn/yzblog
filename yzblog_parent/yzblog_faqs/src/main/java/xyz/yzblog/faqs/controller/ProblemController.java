package xyz.yzblog.faqs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.yzblog.common.consts.StatusCode;
import xyz.yzblog.common.enums.StatusCodeEnum;
import xyz.yzblog.common.utils.ResultUtils;
import xyz.yzblog.common.vo.PageResult;
import xyz.yzblog.common.vo.Result;
import xyz.yzblog.faqs.dataobject.Problem;
import xyz.yzblog.faqs.service.ProblemService;

/**
 * 控制器层
 * 
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;

	/**
	 * 根据标签ID查询最新问题列表
	 * 
	 * @param labelid
	 * @return
	 */
	@RequestMapping(value = "/newlist/{labelid}/{page}/{size}", method = RequestMethod.GET)
	public Result findNewListByLabelId(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
		Page<Problem> pageList = problemService.findNewProblemListByLabelId(labelid, page, size);
		PageResult<Problem> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, pageResult);
	}

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, problemService.findAll());
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, problemService.findById(id));
	}

	/**
	 * 分页+多条件查询
	 * 
	 * @param searchMap 查询条件封装
	 * @param page      页码
	 * @param size      页大小
	 * @return 分页结果
	 */
	@RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
		return ResultUtils.success(StatusCodeEnum.QUERY_OK,
				new PageResult<Problem>(pageList.getTotalElements(), pageList.getContent()));
	}

	/**
	 * 根据条件查询
	 * 
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap) {
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, problemService.findSearch(searchMap));
	}

	/**
	 * 增加
	 * 
	 * @param problem
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result add(@RequestBody Problem problem) {
		problemService.add(problem);
		return ResultUtils.success(StatusCodeEnum.ADD_OK);
	}

	/**
	 * 修改
	 * 
	 * @param problem
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@RequestBody Problem problem, @PathVariable String id) {
		problem.setId(id);
		problemService.update(problem);
		return ResultUtils.success(StatusCodeEnum.UPDATE_OK);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		problemService.deleteById(id);
		return ResultUtils.success(StatusCodeEnum.DELETE_OK);
	}

}
