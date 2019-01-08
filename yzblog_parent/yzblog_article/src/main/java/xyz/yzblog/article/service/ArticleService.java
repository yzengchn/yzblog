package xyz.yzblog.article.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import xyz.yzblog.article.dao.ArticleDao;
import xyz.yzblog.article.dataobject.Article;
import xyz.yzblog.common.utils.IdWorker;

@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private IdWorker idWorker;

	/**
	 * 点赞
	 * 
	 * @param id 文章ID
	 * @return
	 */
	@Transactional
	@CacheEvict(value="article",key="'article_'+#id")
	public int updateThumbup(String id) {
		return articleDao.updateThumbup(id);
	}
	
	/**
	 * 审核
	 * 
	 * @param id 文章ID
	 * @return
	 */
	@Transactional
	@CacheEvict(value="article",key="'article_'+#id")
	public int examine(String id) {
		return articleDao.examine(id);
	}

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Article> findSearch(Map whereMap, int page, int size) {
		Specification<Article> specification = createSpecification(whereMap);
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		return articleDao.findAll(specification, pageRequest);
	}

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	public List<Article> findSearch(Map whereMap) {
		Specification<Article> specification = createSpecification(whereMap);
		return articleDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	@Cacheable(value="article",key="'article_'+#id")
	public Article findById(String id) {
		return articleDao.findById(id).get();
	}

	/**
	 * 增加
	 * 
	 * @param article
	 */
	public void add(Article article) {
		article.setId(idWorker.nextId() + "");
		articleDao.save(article);
	}

	/**
	 * 修改
	 * 
	 * @param article
	 */
	@CacheEvict(value="article",key="'article_'+#article.id")
	public void update(Article article) {
		articleDao.save(article);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@CacheEvict(value="article",key="'article_'+#id")
	public void deleteById(String id) {
		articleDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * 
	 * @param searchMap
	 * @return
	 */
	private Specification<Article> createSpecification(Map searchMap) {

		return new Specification<Article>() {

			@Override
			public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				//
				if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
					predicateList
							.add(cb.like(root.get("id").as(String.class), "%" + (String) searchMap.get("id") + "%"));
				}
				// 专栏ID
				if (searchMap.get("columnId") != null && !"".equals(searchMap.get("columnId"))) {
					predicateList.add(cb.like(root.get("columnId").as(String.class),
							"%" + (String) searchMap.get("columnId") + "%"));
				}
				// 频道ID
				if (searchMap.get("channelId") != null && !"".equals(searchMap.get("channelId"))) {
					predicateList.add(cb.like(root.get("channelId").as(String.class),
							"%" + (String) searchMap.get("channelId") + "%"));
				}
				// 用户ID
				if (searchMap.get("userId") != null && !"".equals(searchMap.get("userId"))) {
					predicateList.add(
							cb.like(root.get("userId").as(String.class), "%" + (String) searchMap.get("userId") + "%"));
				}
				// 用户昵称
				if (searchMap.get("nickname") != null && !"".equals(searchMap.get("nickname"))) {
					predicateList.add(cb.like(root.get("nickname").as(String.class),
							"%" + (String) searchMap.get("nickname") + "%"));
				}
				// 文章标题
				if (searchMap.get("title") != null && !"".equals(searchMap.get("title"))) {
					predicateList.add(
							cb.like(root.get("title").as(String.class), "%" + (String) searchMap.get("title") + "%"));
				}
				// 文章内容
				if (searchMap.get("content") != null && !"".equals(searchMap.get("content"))) {
					predicateList.add(cb.like(root.get("content").as(String.class),
							"%" + (String) searchMap.get("content") + "%"));
				}
				// 文章封面图片路径
				if (searchMap.get("image") != null && !"".equals(searchMap.get("image"))) {
					predicateList.add(
							cb.like(root.get("image").as(String.class), "%" + (String) searchMap.get("image") + "%"));
				}
				// 文章URL地址
				if (searchMap.get("url") != null && !"".equals(searchMap.get("url"))) {
					predicateList
							.add(cb.like(root.get("url").as(String.class), "%" + (String) searchMap.get("url") + "%"));
				}

				return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
