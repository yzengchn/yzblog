package xyz.yzblog.common.utils;

import xyz.yzblog.common.consts.StatusCode;
import xyz.yzblog.common.enums.StatusCodeEnum;
import xyz.yzblog.common.vo.Result;

public class ResultUtils {
	
	/**
	 * 通用请求成功返回结果封装 
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月4日 下午2:43:12
	 * @title success
	 * @param msg 返回消息
	 * @param obj 返回数据
	 * @return ResultVO
	 */
	public static Result success(String msg,Object obj) {
		Result vo = new Result();
		vo.setFlag(true);
		vo.setCode(StatusCode.OK);
		vo.setMsg(msg);
		vo.setData(obj);
		return vo;
	}
	
	public static Result success(StatusCodeEnum enum1,Object obj) {
		Result vo = new Result();
		vo.setFlag(true);
		vo.setCode(enum1.getCode());
		vo.setMsg(enum1.getMsg());
		vo.setData(obj);
		return vo;
	}
	
	public static Result success(StatusCodeEnum enum1) {
		Result vo = new Result();
		vo.setFlag(true);
		vo.setCode(enum1.getCode());
		vo.setMsg(enum1.getMsg());
		return vo;
	}
	
	public static Result fail(StatusCodeEnum enum1,Object obj) {
		Result vo = new Result();
		vo.setFlag(false);
		vo.setCode(enum1.getCode());
		vo.setMsg(enum1.getMsg());
		vo.setData(obj);
		return vo;
	}
}
