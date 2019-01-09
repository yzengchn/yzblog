package xyz.yzblog.search.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import xyz.yzblog.search.dataobject.Article;

public interface ArticleSearchDao extends ElasticsearchRepository<Article, String> {
	/**
	 * 检索
	 * 
	 * @param
	 * @return
	 */
	public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
