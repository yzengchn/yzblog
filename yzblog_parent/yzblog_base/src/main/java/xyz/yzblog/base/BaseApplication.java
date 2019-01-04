package xyz.yzblog.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import xyz.yzblog.common.utils.IdWorker;

@SpringBootApplication
public class BaseApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}
	
	@Bean
	public IdWorker idWorker() {
		return new IdWorker(1, 1);
	}
}
