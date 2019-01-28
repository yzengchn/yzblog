package xyz.yzblog.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import xyz.yzblog.common.consts.StatusCode;
import xyz.yzblog.common.enums.StatusCodeEnum;
import xyz.yzblog.common.utils.ResultUtils;
import xyz.yzblog.common.vo.Result;
import xyz.yzblog.user.dataobject.User;
import xyz.yzblog.user.form.UserForm;
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
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public Result register(@Valid UserForm form, BindingResult bindingResult) {
		try {
			if(bindingResult.hasErrors()) {
				return new Result(true, StatusCode.ERROR, bindingResult.getFieldError().getDefaultMessage());
			}
			
			User user = new User();
			BeanUtils.copyProperties(form, user);
			
			if(userService.register(user)) {
				return ResultUtils.success(StatusCodeEnum.REGISTER_SUCCESS, user);
			}else {
				return null;
			}
		} catch (Exception e) {
			
		}finally {
			
		}
		return null;
	} 
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public Result get(HttpServletRequest request) {
		String token = jwtUtils.createJwt("1546421", "tom", "admin");
		System.out.println(token);
		Claims claims = jwtUtils.parseJwt(token);
		
		Map<String, String> map = new HashMap<>();
		map.put("url", request.getRequestURL().toString());
		map.put("name", claims.getSubject());
		request.getSession().setAttribute("map", map);
		
		System.out.println(claims.getSubject());
		System.out.println(claims.get("roles"));
		return ResultUtils.success(StatusCodeEnum.QUERY_OK);
	} 
	
	@RequestMapping(value="/session",method=RequestMethod.GET)
	public Result session(HttpServletRequest request) {
		
		Map<String, String> map = new HashMap<>();
		map.put("sessionId", request.getSession().getId());
		map.put("map", request.getSession().getAttribute("map").toString());
		
		return ResultUtils.success(StatusCodeEnum.QUERY_OK, map);
	} 
}
