package xyz.yzblog.common.vo;

/**
 * 全局返回结果实体类 
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年1月4日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class Result {
	/**
	 * 是否成功
	 */
	private boolean flag;
	
	/**
	 * 返回码
	 */
	private Integer code;
	
	/**
	 * 返回信息
	 */
	private String msg;
	
	/**
	 * 返回数据
	 */
	private Object data;
	
	
	
	public Result(boolean flag, Integer code, String msg) {
		super();
		this.flag = flag;
		this.code = code;
		this.msg = msg;
	}

	public Result() {
	}

	public Result(boolean flag, Integer code, String msg, Object data) {
		super();
		this.flag = flag;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
