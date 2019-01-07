package xyz.yzblog.faqs.dataobject;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 问题表 
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年1月7日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
@Entity
@Table(name="tb_problem")
public class Problem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    /**
    * id
    */
    private String id;

    /**
    * 发布人id
    */
    private String userId;

    /**
    * 发布人昵称
    */
    private String nickname;

    /**
    * 问题标题
    */
    private String title;

    /**
    * 问题内容
    */
    private String content;

    /**
    * 游览量
    */
    private long visits;

    /**
    * 点赞数
    */
    private long thumbup;

    /**
    * 回复数
    */
    private long reply;

    /**
    * 是否解决，0已解决 1未解决
    */
    private int solve;

    /**
    * 状态
    */
    private String state;

    /**
    * 最新回复人
    */
    private String replyName;

    /**
    * 最新回复时间
    */
    private Date replyTime;

    /**
    * 文章发布时间
    */
    private Date createTime;

    /**
    * 文章更新时间
    */
    private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getVisits() {
		return visits;
	}

	public void setVisits(long visits) {
		this.visits = visits;
	}

	public long getThumbup() {
		return thumbup;
	}

	public void setThumbup(long thumbup) {
		this.thumbup = thumbup;
	}

	public long getReply() {
		return reply;
	}

	public void setReply(long reply) {
		this.reply = reply;
	}

	public int getSolve() {
		return solve;
	}

	public void setSolve(int solve) {
		this.solve = solve;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
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