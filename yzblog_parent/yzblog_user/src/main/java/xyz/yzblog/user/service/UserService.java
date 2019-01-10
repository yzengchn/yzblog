package xyz.yzblog.user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendSms(String mobileNum) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("mobileNum", mobileNum);
		paramMap.put("validity", "5");//验证码有效期(分钟)如："5"
		rabbitTemplate.convertAndSend("yzblog", "sms.code", paramMap);
	}
	
}
