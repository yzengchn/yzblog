package xyz.yzblog.faqs.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import xyz.yzblog.faqs.dataobject.Problem;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
	
	@Query("select p from Problem p where id in( select problemId from ProblemLabel where labelId=?1 ) order by replyTime desc")
	public Page<Problem> findNewProblemListByLabelId(String labelId, Pageable pageable);
	
	
	@Query("select p from Problem p where id in( select problemId from ProblemLabel where labelId=?1 ) order by reply desc")
	public Page<Problem> findHotProblemListByLabelId(String labelId, Pageable pageable);
	
	
	@Query("select p from Problem p where id in( select problemId from ProblemLabel where labelId=?1 ) and reply=0 order by createTime desc")
	public Page<Problem> findWaitProblemListByLabelId(String labelId, Pageable pageable);
}
