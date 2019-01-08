package xyz.yzblog.article.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*  article
* @author 大狼狗 2019-01-08
*/
@Entity
@Table(name="article")
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    /**
    * id
    */
    private String id;

    /**
    * 专栏id
    */
    private String columnId;

    /**
    * 频道id
    */
    private String channelId;

    /**
    * 用户id
    */
    private String userId;

    /**
    * 用户昵称
    */
    private String nickname;

    /**
    * 文章标题
    */
    private String title;

    /**
    * 文章内容
    */
    private String content;

    /**
    * 文章封面图片路径
    */
    private String image;

    /**
    * 发表时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 是否公开 0:不公开，1:公开
    */
    private int openly;

    /**
    * 是否置顶 0:否，1:是
    */
    private int istop;

    /**
    * 游览量
    */
    private long visits;

    /**
    * 点赞数
    */
    private long thumbup;

    /**
    * 评论数
    */
    private long comment;

    /**
    * 审核状态，0未审核 1已审核
    */
    private int state;

    /**
    * 文章类型，0:分享 1:专栏
    */
    private int type;

    /**
    * 文章url地址
    */
    private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public int getOpenly() {
		return openly;
	}

	public void setOpenly(int openly) {
		this.openly = openly;
	}

	public int getIstop() {
		return istop;
	}

	public void setIstop(int istop) {
		this.istop = istop;
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

	public long getComment() {
		return comment;
	}

	public void setComment(long comment) {
		this.comment = comment;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
    

}