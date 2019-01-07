package xyz.yzblog.faqs.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 回答表 
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年1月7日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
@Entity
@Table(name="tb_reply")
public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    /**
    * id
    */
    private String id;

    /**
    * 问题id
    */
    private String problemId;

    /**
    * 回答人id
    */
    private String userId;

    /**
    * 回答人昵称
    */
    private String nickname;

    /**
    * 回答内容
    */
    private String content;

    /**
    * 回答时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
