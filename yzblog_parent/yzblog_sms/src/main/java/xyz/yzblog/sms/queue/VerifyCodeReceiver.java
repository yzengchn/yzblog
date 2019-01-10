package xyz.yzblog.sms.queue;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import xyz.yzblog.sms.utils.SmsUtils;

@Component
@RabbitListener(queues="sms.code")
public class VerifyCodeReceiver {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private SmsUtils smsUtils;
	
	@RabbitHandler
	public void sendSms(Map<String,String> map) {
		//手机号
		String mobileNum = map.get("mobileNum");
		//验证码有效期(分钟)
		long validity = Long.parseLong(map.get("validity"));
		//验证码
		String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
		
		stringRedisTemplate.opsForValue().set("verifycode_"+mobileNum, verifyCode, validity, TimeUnit.MINUTES);
		String code = stringRedisTemplate.opsForValue().get("verifycode_"+mobileNum);
		//smsUtils.sendVerifySms(mobileNum, code, "5", "注册");
		System.out.println(code);
	}
}
