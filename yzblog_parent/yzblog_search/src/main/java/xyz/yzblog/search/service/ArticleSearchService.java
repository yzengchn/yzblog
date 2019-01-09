package xyz.yzblog.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import xyz.yzblog.search.dao.ArticleSearchDao;
import xyz.yzblog.search.dataobject.Article;

@Service
public class ArticleSearchService {

	@Autowired
	private ArticleSearchDao articleSearchDao;

	/**
	 * 增加文章
	 * 
	 * @param article
	 */
	public Article add(Article article) {
		return articleSearchDao.save(article);
	}

	public Page<Article> findByTitleLike(String keywords, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		return articleSearchDao.findByTitleOrContentLike(keywords, keywords, pageRequest);
	}
}
