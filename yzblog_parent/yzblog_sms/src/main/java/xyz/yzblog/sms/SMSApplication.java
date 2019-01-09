package xyz.yzblog.sms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.yzblog.common.utils.IdWorker;
@SpringBootApplication
public class SMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(SMSApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
