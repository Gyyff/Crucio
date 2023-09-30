package com.heiqi.chat.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JwtUtil {

    /**
     * JWT认证加密私钥(Base64加密)
     */
    private static String ENCRYPT_JWT_KEY;

    /**
     * 环境对应的值
     */
    private static Integer ENV;

    @Value("${auth.encryptJWTKey}")
    public void setEncryptJWTKey(String encryptJWTKey) {
        JwtUtil.ENCRYPT_JWT_KEY = encryptJWTKey;
    }

    private static Logger log = LoggerFactory.getLogger(JwtUtil.class);

    public static Object verifyAndGetValue(String token, String key) throws Exception {
        if(StringUtils.hasText(token) && StringUtils.hasText(key)) {

            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(Base64ConvertUtil.decode(ENCRYPT_JWT_KEY))).build().verify(token);
            return decodedJWT.getClaim(key);
        }
        return null;
    }

    /**
     * 生成签名
     */
    public static String sign(int uid)  {
        try {
            String secret = Base64ConvertUtil.decode(ENCRYPT_JWT_KEY);
            // 此处过期时间是以毫秒为单位，所以乘以1000
            Algorithm algorithm = Algorithm.HMAC256(secret);

            // 附带account帐号信息
            return JWT.create()
                    .withClaim("uid", uid)
                    .withClaim("currentTimeMillis", System.currentTimeMillis())
                    .sign(algorithm);
        }catch (Exception e){
            log.error("签名生成失败 uid = {}", uid, e);
        }
        return null;
    }
}
