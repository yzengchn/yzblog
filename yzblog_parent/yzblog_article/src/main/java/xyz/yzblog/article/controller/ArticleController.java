package xyz.yzblog.article.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.yzblog.article.dataobject.Article;
import xyz.yzblog.article.service.ArticleService;
import xyz.yzblog.common.consts.StatusCode;
import xyz.yzblog.common.enums.StatusCodeEnum;
import xyz.yzblog.common.utils.ResultUtils;
import xyz.yzblog.common.vo.PageResult;
import xyz.yzblog.common.vo.Result;

/**
 * 控制器层
 * 
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	/**
	 * 点赞
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/thumbup/{id}", method = RequestMethod.PUT)
	public Result updateThumbup(@PathVariable String id) {
		int i = articleService.updateThumbup(id);
		if(i > 0) {
			return ResultUtils.success(StatusCodeEnum.THUMBUP_OK);
		}
		return ResultUtils.success(StatusCodeEnum.ERROR);
	}

	/**
	 * 审核
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/examine/{id}", method = RequestMethod.PUT)
	public Result examine(@PathVariable String id) {
		int i = articleService.examine(id);
		if (i > 0) {
			return ResultUtils.success(StatusCodeEnum.EXAMINE_OK);
		}
		return ResultUtils.success(StatusCodeEnum.ERROR);
	}

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, articleService.findAll());
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, articleService.findById(id));
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
		Page<Article> pageList = articleService.findSearch(searchMap, page, size);
		return ResultUtils.success(StatusCodeEnum.QUERY_OK,
				new PageResult<Article>(pageList.getTotalElements(), pageList.getContent()));
	}

	/**
	 * 根据条件查询
	 * 
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap) {
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, articleService.findSearch(searchMap));
	}

	/**
	 * 增加
	 * 
	 * @param article
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result add(@RequestBody Article article) {
		articleService.add(article);
		return ResultUtils.success(StatusCodeEnum.ADD_OK);
	}

	/**
	 * 修改
	 * 
	 * @param article
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@RequestBody Article article, @PathVariable String id) {
		article.setId(id);
		articleService.update(article);
		return ResultUtils.success(StatusCodeEnum.UPDATE_OK);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		articleService.deleteById(id);
		return ResultUtils.success(StatusCodeEnum.DELETE_OK);
	}

	
	@RequestMapping(value="/session",method=RequestMethod.GET)
	public Result session(HttpServletRequest request) {
		
		Map<String, String> map = new HashMap<>();
		map.put("sessionId", request.getSession().getId());
		map.put("map", request.getSession().getAttribute("map").toString());
		
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, map);
	} 
}
