package xyz.yzblog.user.dataobject;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体 
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年1月21日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
@Entity
@Table(name="user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * id
    */
    @Id
    private String id;

    /**
    * 手机号码
    */
    private String mobile;

    /**
    * 登录名
    */
    private String loginName;

    /**
    * 密码
    */
    private String password;

    /**
    * 昵称
    */
    private String nickname;

    /**
    * 性别(0：未知，1：男，2：女)
    */
    private int sex;

    /**
    * 出生年月日
    */
    private Date birthday;

    /**
    * 头像
    */
    private String avatar;

    /**
    * e-mail
    */
    private String email;

    /**
    * 注册日期
    */
    private Date regdate;

    /**
    * 修改日期
    */
    private Date updatedate;

    /**
    * 最后登陆日期
    */
    private Date lastdate;

    /**
    * 在线时长（分钟）
    */
    private long online;

    /**
    * 兴趣
    */
    private String interest;

    /**
    * 个性
    */
    private String personality;

    /**
    * 粉丝数
    */
    private int fanscount;

    /**
    * 关注数
    */
    private int followcount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Date getLastdate() {
		return lastdate;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	public long getOnline() {
		return online;
	}

	public void setOnline(long online) {
		this.online = online;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public int getFanscount() {
		return fanscount;
	}

	public void setFanscount(int fanscount) {
		this.fanscount = fanscount;
	}

	public int getFollowcount() {
		return followcount;
	}

	public void setFollowcount(int followcount) {
		this.followcount = followcount;
	}
    
    

}