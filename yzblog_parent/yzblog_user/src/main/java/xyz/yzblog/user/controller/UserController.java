package xyz.yzblog.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import xyz.yzblog.common.enums.StatusCodeEnum;
import xyz.yzblog.common.utils.ResultUtils;
import xyz.yzblog.common.vo.Result;
import xyz.yzblog.user.service.UserService;
import xyz.yzblog.user.utils.JwtUtils;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/sendsms/{mobileNum}",method=RequestMethod.GET)
	public void sendSms(@PathVariable String mobileNum) {
		userService.sendSms(mobileNum);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Result login(@RequestBody Map<String,String> paramMap) {
		if(!paramMap.containsKey("nameOrMobile") || !paramMap.containsKey("password")) {
			return ResultUtils.error(StatusCodeEnum.ERROR);
		}
		if(StringUtils.isEmpty(paramMap.get("nameOrMobile")) || StringUtils.isEmpty(paramMap.get("password"))) {
			return ResultUtils.error(StatusCodeEnum.ERROR);
		}
		return userService.login(paramMap);
	} 
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public void get() {
		String token = jwtUtils.createJwt("1546421", "tom", "admin");
		System.out.println(token);
		Claims claims = jwtUtils.parseJwt(token);
		
		System.out.println(claims.getSubject());
		System.out.println(claims.get("roles"));
	} 
}
