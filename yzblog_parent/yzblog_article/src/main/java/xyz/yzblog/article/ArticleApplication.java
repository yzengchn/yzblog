package xyz.yzblog.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.yzblog.common.utils.IdWorker;

@SpringBootApplication
@EnableCaching
@EnableRedisHttpSession
@Controller
public class ArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public String toSwaggerUI() {
		return "redirect:/swagger-ui.html";
	} 
	
}
