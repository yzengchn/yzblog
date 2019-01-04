package xyz.yzblog.common.consts;

/**
 * 状态常量
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年1月4日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class StatusCode {
	/**
	 * 成功
	 */
	public static final int OK = 20000;// 成功
	/**
	 * 失败
	 */
	public static final int ERROR = 20001;// 失败
	/**
	 * 用户名或密码错误
	 */
	public static final int LOGINERROR = 20002;// 用户名或密码错误
	/**
	 * 权限不足
	 */
	public static final int ACCESSERROR = 20003;// 权限不足
	/**
	 * 远程调用失败
	 */
	public static final int REMOTEERROR = 20004;// 远程调用失败
	/**
	 * 重复操作
	 */
	public static final int REPERROR = 20005;// 重复操作
}
