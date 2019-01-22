package xyz.yzblog.user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import xyz.yzblog.common.enums.StatusCodeEnum;
import xyz.yzblog.common.utils.ResultUtils;
import xyz.yzblog.common.vo.Result;
import xyz.yzblog.user.controller.BaseExceptionHandler;
import xyz.yzblog.user.dao.UserDao;
import xyz.yzblog.user.dataobject.User;
import xyz.yzblog.user.utils.JwtUtils;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	public Map<String,String> register(){
		return null;
	}
	
	public Result login(Map<String,String> paramMap){
		
		User user = userDao.findByloginNameOrMobile(paramMap.get("nameOrMobile"));
		if(user == null) {
			return ResultUtils.error(StatusCodeEnum.USER_NOT_EXIST);
		}
		if(!user.getPassword().equals(paramMap.get("password"))) {
			return ResultUtils.error(StatusCodeEnum.LOGINERROR);
		}
		String token = jwtUtils.createJwt(user.getId(), user.getLoginName(), "admin");
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", user.getNickname());
		map.put("loginName", user.getLoginName());
		map.put("token", token);
		return ResultUtils.success(StatusCodeEnum.LOGIN_SUCCESS,map);
	}
	
	public User findById(String id) {
		return userDao.findById(id).get();
		
	}
	
	public void sendSms(String mobileNum) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("mobileNum", mobileNum);
		paramMap.put("validity", "5");//验证码有效期(分钟)如："5"
		rabbitTemplate.convertAndSend("yzblog", "sms.code", paramMap);
	}
	
}
