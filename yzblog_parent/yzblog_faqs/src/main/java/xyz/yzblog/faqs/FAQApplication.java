package xyz.yzblog.faqs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.yzblog.common.utils.IdWorker;
@SpringBootApplication
public class FAQApplication {

	public static void main(String[] args) {
		SpringApplication.run(FAQApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
