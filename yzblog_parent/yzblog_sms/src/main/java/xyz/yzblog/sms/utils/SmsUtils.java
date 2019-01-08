package xyz.yzblog.sms.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import java.io.IOException;

import org.json.JSONException;

public class SmsUtils {
	// 短信应用SDK AppID
	public static int appid = 1400; // 1400开头

	// 短信应用SDK AppKey
	public static String appkey = "501191b74f5";
	
	public static void sendSms() {
		try {
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		    SmsSingleSenderResult result = ssender.send(0, "86", "a927a3bb0a36ef779cadc",
		        "【腾讯云】您的验证码是: 5678", "", "");
		    System.out.println(result);
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
	}
	
	public static void main(String[] args) {
		sendSms();
	}
}
