package xyz.yzblog.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
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
	public void login() {
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
