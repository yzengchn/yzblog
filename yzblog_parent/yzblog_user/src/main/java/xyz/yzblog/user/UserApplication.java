package xyz.yzblog.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import xyz.yzblog.common.utils.IdWorker;
@SpringBootApplication
@EnableRedisHttpSession
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
