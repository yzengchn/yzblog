package xyz.yzblog.sms.utils;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

@Component
public class SmsUtils {
	//国家码
	private static final String NATION_CODE = "86";  
	
	@Value("${service.templateid}")
	private String TEMPLATE_ID;  
	
	@Value("${service.appid}")
	public String APPID; 

	@Value("${service.appkey}")
	public String APPKEY;
	
	/**
	 * 发送短信验证码
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2019年1月9日 下午3:06:23
	 * @title sendVerifySms
	 * @param phoneNumber 手机号码
	 * @param VerifyCode  验证码
	 * @param validity    验证码有效期(分钟)
	 * @param sign        签名
	 * @return SmsSingleSenderResult
	 */
	public SmsSingleSenderResult sendVerifySms(String phoneNumber,String VerifyCode, String validity, String sign) {
		try {
			ArrayList<String> params = new ArrayList<String>();
			params.add(VerifyCode);
			params.add(validity);
		    SmsSingleSender ssender = new SmsSingleSender(Integer.parseInt(APPID), APPKEY);
		    SmsSingleSenderResult result = ssender.sendWithParam(NATION_CODE, phoneNumber, Integer.parseInt(TEMPLATE_ID), params, sign, "", "");
		    System.out.println(result);
		    return result;
		} catch (HTTPException e) {
		    // HTTP响应码错误
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json解析错误
		    e.printStackTrace();
		} catch (IOException e) {
		    // 网络IO错误
		    e.printStackTrace();
		}
		return null;
	}
	
}
