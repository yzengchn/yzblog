package xyz.yzblog.user.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
@ConfigurationProperties(prefix="jwt.config")
public class JwtUtils {
	/**
	 * 签名
	 */
	private String key;
	/**
	 * 有效期
	 */
	private long validity;
	
	
	/**
     * 创建jwt
     * @param id
     * @param subject
     * @param roles
     * @return
     * @throws Exception
     */
	public String createJwt(String id, String subject, String roles) {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		JwtBuilder builder = Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuedAt(now)
				.signWith(SignatureAlgorithm.HS256, generalKey())
				.claim("roles", roles);
		
		if(validity > 0) {
			builder.setExpiration(new Date(nowMillis+validity));
		}
		
		return builder.compact();
	}
	
	/**
     * 解密jwt
     * @param jwtStr
     * @return
     */
	public Claims parseJwt(String jwtStr) {
		return Jwts.parser()
				.setSigningKey(generalKey())
				.parseClaimsJws(jwtStr)
				.getBody();
	}
	
	/**
     * 由字符串生成加密key
     * @return
     */
    public String generalKey(){
        String stringKey = this.key;
        try {
			return Base64.getEncoder().encodeToString(stringKey.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return stringKey;
    }
	
	public long getValidity() {
		return validity;
	}
	public void setValidity(long validity) {
		this.validity = validity;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
}
