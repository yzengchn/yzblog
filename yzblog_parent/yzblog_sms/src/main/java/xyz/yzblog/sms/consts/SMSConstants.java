package xyz.yzblog.sms.consts;

import xyz.yzblog.sms.utils.PropertiesLoader;

public class SMSConstants {
	
	public static final String SMS_CONFIG_FILE = "config/sms.properties";
	
	public static final String APPID = PropertiesLoader.getKey(SMS_CONFIG_FILE, "appid");

	public static final String APPSECRET = PropertiesLoader.getKey(SMS_CONFIG_FILE, "appkey");
	
	public static final String TEMPLATEID = PropertiesLoader.getKey(SMS_CONFIG_FILE, "templateid");
}
