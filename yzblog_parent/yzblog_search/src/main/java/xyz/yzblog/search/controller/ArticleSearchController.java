package xyz.yzblog.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.yzblog.common.enums.StatusCodeEnum;
import xyz.yzblog.common.utils.ResultUtils;
import xyz.yzblog.common.vo.PageResult;
import xyz.yzblog.common.vo.Result;
import xyz.yzblog.search.dataobject.Article;
import xyz.yzblog.search.service.ArticleSearchService;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {

	@Autowired
	private ArticleSearchService articleSearchService;

	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody Article article) {
		Article result = articleSearchService.add(article);
		if (result == null) {
			return ResultUtils.success(StatusCodeEnum.ERROR);
		}
		return ResultUtils.success(StatusCodeEnum.ADD_OK);
	}

	@RequestMapping(value = "/search/{keywords}/{page}/{size}", method = RequestMethod.GET)
	public Result findByTitleLike(@PathVariable String keywords, @PathVariable int page, @PathVariable int size) {
		Page<Article> articlePage = articleSearchService.findByTitleLike(keywords, page, size);
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, new PageResult<Article>(articlePage.getTotalElements(), articlePage.getContent()));
	}
}
