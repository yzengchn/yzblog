package xyz.yzblog.base.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.yzblog.common.consts.StatusCode;
import xyz.yzblog.common.vo.Result;

/**
 * 异常处理 
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年1月4日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */

@ControllerAdvice
public class BaseExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result error(Exception e) {
		return new Result(false, StatusCode.ERROR, e.getMessage());
	}
}
