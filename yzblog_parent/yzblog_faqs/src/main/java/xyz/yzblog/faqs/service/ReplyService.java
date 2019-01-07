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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import xyz.yzblog.common.utils.IdWorker;
import xyz.yzblog.faqs.dao.ReplyDao;
import xyz.yzblog.faqs.dataobject.Reply;


/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class ReplyService {

	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Reply> findAll() {
		return replyDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Reply> findSearch(Map whereMap, int page, int size) {
		Specification<Reply> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return replyDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Reply> findSearch(Map whereMap) {
		Specification<Reply> specification = createSpecification(whereMap);
		return replyDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Reply findById(String id) {
		return replyDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param reply
	 */
	public void add(Reply reply) {
		reply.setId( idWorker.nextId()+"" );
		replyDao.save(reply);
	}

	/**
	 * 修改
	 * @param reply
	 */
	public void update(Reply reply) {
		replyDao.save(reply);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		replyDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Reply> createSpecification(Map searchMap) {

		return new Specification<Reply>() {

			@Override
			public Predicate toPredicate(Root<Reply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 问题ID
                if (searchMap.get("problem_id")!=null && !"".equals(searchMap.get("problem_id"))) {
                	predicateList.add(cb.like(root.get("problem_id").as(String.class), "%"+(String)searchMap.get("problem_id")+"%"));
                }
                // 回答人ID
                if (searchMap.get("user_id")!=null && !"".equals(searchMap.get("user_id"))) {
                	predicateList.add(cb.like(root.get("user_id").as(String.class), "%"+(String)searchMap.get("user_id")+"%"));
                }
                // 回答人昵称
                if (searchMap.get("nickname")!=null && !"".equals(searchMap.get("nickname"))) {
                	predicateList.add(cb.like(root.get("nickname").as(String.class), "%"+(String)searchMap.get("nickname")+"%"));
                }
                // 回答内容
                if (searchMap.get("content")!=null && !"".equals(searchMap.get("content"))) {
                	predicateList.add(cb.like(root.get("content").as(String.class), "%"+(String)searchMap.get("content")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
