package xyz.yzblog.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import xyz.yzblog.user.filter.JwtFilter;


//@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport{

	@Autowired
	private JwtFilter jwtFilter;
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtFilter)
				.addPathPatterns("/**")
				.excludePathPatterns("/**/login");
	}
}
