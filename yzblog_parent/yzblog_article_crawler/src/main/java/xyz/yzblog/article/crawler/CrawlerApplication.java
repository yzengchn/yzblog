package xyz.yzblog.article.crawler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import us.codecraft.webmagic.scheduler.RedisScheduler;
import xyz.yzblog.common.utils.IdWorker;
import xyz.yzblog.common.utils.PropertiesLoader;
@SpringBootApplication
//@EnableCaching
@EnableScheduling
public class CrawlerApplication {

	@Value("${redis.host}")
	private String redis_host;
	
	public static void main(String[] args) {
		SpringApplication.run(CrawlerApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
	@Bean
	public RedisScheduler redisScheduler() {
		System.out.println(redis_host);
		return new RedisScheduler(redis_host);
	}
	
}
