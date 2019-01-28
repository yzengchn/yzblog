package xyz.yzblog.user.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


/**
 * 用户VO类
 * 
 * @author <a href="http://www.yzblog.xyz">yzblog</a>
 * @version [1.0, 2019年1月21日]
 * @Email yzengchn@163.com
 * @since [产品/模块版本]
 */
public class UserForm {
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
	@NotBlank(message = "密码不能为空！")
	private String password;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * e-mail
	 */
	@Email(message = "邮箱格式不正确！")
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
