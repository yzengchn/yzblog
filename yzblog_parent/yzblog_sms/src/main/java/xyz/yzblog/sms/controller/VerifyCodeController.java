package xyz.yzblog.sms.controller;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import xyz.yzblog.common.utils.IdWorker;

@RestController("verifyCode")
public class VerifyCodeController {

	@Autowired
	private IdWorker idWorker;
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
    private DefaultKaptcha captchaProducer;
	
	/**
	 * 获得验证码
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月28日 下午3:30:22
	 * @title getKaptchaImage
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @return ModelAndView
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getKaptchaImage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control","no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
 
		String capText = captchaProducer.createText();
 
		try {
			String uuid=idWorker.nextId()+"";		
			redisTemplate.opsForValue().set(uuid, capText,60*5,TimeUnit.SECONDS);
			Cookie cookie = new Cookie("captchaCode",uuid);
			System.out.println("captchaCode:"+ uuid +"---capText: " + capText);
	        response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
 
 
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}

	
}
