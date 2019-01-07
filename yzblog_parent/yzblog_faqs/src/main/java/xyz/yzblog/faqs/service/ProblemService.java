package xyz.yzblog.faqs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import xyz.yzblog.common.utils.IdWorker;
import xyz.yzblog.faqs.dao.ProblemDao;
import xyz.yzblog.faqs.dataobject.Problem;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class ProblemService {

	@Autowired
	private ProblemDao problemDao;

	@Autowired
	private IdWorker idWorker;

	/**
	 * 根据标签ID查询问题列表
	 * 
	 * @param lableId 标签ID
	 * @param page    页码
	 * @param size    页大小
	 * @return
	 */
	public Page<Problem> findNewProblemListByLabelId(String labelId, int page, int size){
		PageRequest pageRequest = PageRequest.of(page-1, size);
		return problemDao.findNewProblemListByLabelId(labelId,pageRequest); 
	}

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	public List<Problem> findAll() {
		return problemDao.findAll();
	}

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Problem> findSearch(Map whereMap, int page, int size) {
		Specification<Problem> specification = createSpecification(whereMap);
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		return problemDao.findAll(specification, pageRequest);
	}

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	public List<Problem> findSearch(Map whereMap) {
		Specification<Problem> specification = createSpecification(whereMap);
		return problemDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	public Problem findById(String id) {
		return problemDao.findById(id).get();
	}

	/**
	 * 增加
	 * 
	 * @param problem
	 */
	public void add(Problem problem) {
		problem.setId(idWorker.nextId() + "");
		problemDao.save(problem);
	}

	/**
	 * 修改
	 * 
	 * @param problem
	 */
	public void update(Problem problem) {
		problemDao.save(problem);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteById(String id) {
		problemDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * 
	 * @param searchMap
	 * @return
	 */
	private Specification<Problem> createSpecification(Map searchMap) {

		return new Specification<Problem>() {

			@Override
			public Predicate toPredicate(Root<Problem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				//
				if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
					predicateList
							.add(cb.like(root.get("id").as(String.class), "%" + (String) searchMap.get("id") + "%"));
				}
				// 发布人ID
				if (searchMap.get("userId") != null && !"".equals(searchMap.get("userId"))) {
					predicateList.add(
							cb.like(root.get("userId").as(String.class), "%" + (String) searchMap.get("userId") + "%"));
				}
				// 发布人昵称
				if (searchMap.get("nickname") != null && !"".equals(searchMap.get("nickname"))) {
					predicateList.add(cb.like(root.get("nickname").as(String.class),
							"%" + (String) searchMap.get("nickname") + "%"));
				}
				// 问题标题
				if (searchMap.get("title") != null && !"".equals(searchMap.get("title"))) {
					predicateList.add(
							cb.like(root.get("title").as(String.class), "%" + (String) searchMap.get("title") + "%"));
				}
				// 问题内容
				if (searchMap.get("content") != null && !"".equals(searchMap.get("content"))) {
					predicateList.add(cb.like(root.get("content").as(String.class),
							"%" + (String) searchMap.get("content") + "%"));
				}
				// 状态
				if (searchMap.get("state") != null && !"".equals(searchMap.get("state"))) {
					predicateList.add(
							cb.like(root.get("state").as(String.class), "%" + (String) searchMap.get("state") + "%"));
				}
				// 最新回复人
				if (searchMap.get("replyName") != null && !"".equals(searchMap.get("replyName"))) {
					predicateList.add(cb.like(root.get("replyName").as(String.class),
							"%" + (String) searchMap.get("replyName") + "%"));
				}

				return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
