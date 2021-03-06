package xyz.yzblog.common.enums;


/**
 * 状态码 
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年1月4日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public enum StatusCodeEnum {
	/**
	 * code: 1000
	 * msg: 登录成功
	 */
	LOGIN_SUCCESS(1000, "登录成功！"),
	/**
	 * code: 1001
	 * msg: 注册成功
	 */
	REGISTER_SUCCESS(1001, "注册成功！"),
	/**
	 * code: 1081
	 * msg: 注册失败
	 */
	REGISTER_FAIL(1023, "注册失败，请重试！"),
	
	/**
	 * code: 1021
	 * msg: 用户名或密码错误
	 */
	USER_PASSWORD_ERROR(1021,"用户名或密码错误！"),
	
	/**
	 * code: 1022
	 * msg: 两次密码输入不一致
	 */
	PASSWORD_INCONSISTENT(1022,"两次密码输入不一致！"),
	
	/**
	 * code: 1023
	 * msg: 原密码输入错误
	 */
	OLD_PASSWORD_ERROR(1023,"原密码输入错误！"),
	
	/**
	 * code: 1091
	 * msg: 用户不存在
	 */
	USER_NOT_EXIST(1091,"用户不存在！"),
	
	/**
	 * code: 1099
	 * msg: 保存用户失败
	 */
	USER_SAVE_FAIL(1099,"保存用户失败！"),
	
	
	/**
	 * 20000,"查询成功"
	 */
	QUERY_OK(20000,"查询成功"),
	/**
	 * 20000,"增加成功"
	 */
	ADD_OK(20000,"增加成功"),
	/**
	 * 20000,"修改成功"
	 */
	UPDATE_OK(20000,"修改成功"),
	/**
	 * 20000,"删除成功"
	 */
	DELETE_OK(20000,"删除成功"),
	/**
	 * 20000,"审核成功"
	 */
	EXAMINE_OK(20000,"审核成功"),
	/**
	 * 20000,"点赞成功"
	 */
	THUMBUP_OK(20000,"点赞成功"),
	/**
	 * 20000,"成功"
	 */
	OK(20000,"成功"),
	/**
	 * 20000,"失败"
	 */
	ERROR(20001,"失败"),
	/**
	 * 20000,"用户名或者密码错误"
	 */
	LOGINERROR(20002,"用户名或者密码错误"),
	/**
	 * 20000,"权限不足"
	 */
	ACCESSERROR(20003,"权限不足"),
	/**
	 * 20000,"远程调用失败"
	 */
	REMOTEERROR(20004,"远程调用失败"),
	/**
	 * 20000,"重复操作"
	 */
	REPERROR(20005,"重复操作"),;
	
	private Integer code;
	private String msg;
	
	StatusCodeEnum(Integer code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
