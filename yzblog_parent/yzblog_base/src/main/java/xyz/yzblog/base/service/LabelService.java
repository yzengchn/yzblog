package xyz.yzblog.base.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import xyz.yzblog.base.dataobject.Label;

public interface LabelService {
	/**
	 * 查询全部标签 
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月4日 下午2:19:55
	 * @title findAll
	 * @return List<Label>
	 */
	List<Label> findAll();
	
	/**
	 * 条件查询
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月4日 下午2:21:03
	 * @title findSearch
	 * @param searchMap
	 * @return List<Label>
	 */
	List<Label> findSearch(Map<String, String> searchMap);
	
	/**
	 * 条件查询
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月4日 下午2:21:03
	 * @title findSearch
	 * @param searchMap
	 * @param page
	 * @param size
	 * @return List<Label>
	 */
	Page<Label> findSearch(Map<String, String> searchMap,int page, int size);
	
	/**
	 * 根据ID查询标签 
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月4日 下午2:21:03
	 * @title findById
	 * @param id
	 * @return Label
	 */
	Label findById(String id);
	
	
	/**
	 * 增加标签 
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月4日 下午2:22:26
	 * @title add
	 * @param label
	 * @return void
	 */
	void add(Label label);
	
	/**
	 * 更新标签 
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月4日 下午2:24:05
	 * @title update
	 * @param label
	 * @return void
	 */
	void update(Label label);
	
	/**
	 * 根据ID删除标签 
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月4日 下午2:24:52
	 * @title deleteById
	 * @param id
	 * @return void
	 */
	void deleteById(String id);
}
