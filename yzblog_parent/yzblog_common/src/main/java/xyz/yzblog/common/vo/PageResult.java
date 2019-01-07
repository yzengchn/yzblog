package xyz.yzblog.common.vo;

import java.util.List;

/**
 * 全局分页返回结果类 
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年1月4日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class PageResult<T> {
	/**
	 * 总条数
	 */
	private Long total;
	
	/**
	 * 数据列表
	 */
	private List<T> rows;
	
	
	
	public PageResult() {
	}

	public PageResult(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
}
