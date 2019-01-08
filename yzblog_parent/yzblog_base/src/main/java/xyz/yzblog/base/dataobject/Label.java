package xyz.yzblog.base.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 标签实体
 * 
 * @author <a href="http://www.yzblog.xyz">yzblog</a>
 * @version [1.0, 2019年1月4日]
 * @Email yzengchn@163.com
 * @since [产品/模块版本]
 */

@Entity
@Table(name = "label")
public class Label {
	@Id
	private String id;//
	private String labelname;// 标签名称
	private String state;// 状态
	private Long count;// 使用数量
	private Long fans;// 关注数
	private String recommend;// 是否推荐
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabelname() {
		return labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getFans() {
		return fans;
	}

	public void setFans(Long fans) {
		this.fans = fans;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
