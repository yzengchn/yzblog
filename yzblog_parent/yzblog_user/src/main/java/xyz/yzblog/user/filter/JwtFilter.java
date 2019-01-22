package xyz.yzblog.user.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class JwtFilter extends HandlerInterceptorAdapter{
	private final static Logger log = LoggerFactory.getLogger(JwtFilter.class);
/*
在preHandle中，可以进行编码、安全控制等处理
在postHandle中，有机会修改ModelAndView
在afterCompletion中，可以根据ex是否为null判断是否发生了异常，进行日志记录
 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("进入拦截器");
		
		
		return true;
	}
}
