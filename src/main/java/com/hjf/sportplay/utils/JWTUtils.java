package com.hjf.sportplay.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Map;

/**
 * JWT工具类
 * @author hjf
 */
public class JWTUtils {
    /**
     * token有效时长 (24小时)
     */
    private static final int EXPIRE_TIME = 60 * 24;

    /**
     * 秘钥
     */
    private static final String SECRET_KEY = "&13tok11*fas";

    /**
     * 生成并获得token
     * @param claims 用户不敏感信息 (key,value)信息
     * @param username 默认需要username
     * @return
     */
    public static String getToken(Map<String, String> claims, String username){
        JWTCreator.Builder builder = JWT.create(); //创建JWT
        if (!StringUtils.isEmpty(username)) {
            builder.withClaim("username",username);
        }
        if (claims != null) {
            claims.forEach((k, v) -> {
                builder.withClaim(k,v); //将一些 用户不敏感信息 放到里面 token的Payload里
            });
        }
        Calendar time = Calendar.getInstance();
        time.add(Calendar.MINUTE,EXPIRE_TIME); // 以分钟为单位 在当前时间下加 60*24 分钟 (24小时)
        builder.withExpiresAt(time.getTime()); // 设置到期时刻
        String token = builder.sign(Algorithm.HMAC256(SECRET_KEY)).toString(); //用HMAC256进行加密生成token
        return token;
    }

    /**
     * 校验 token 是否正确
     * @param token
     * @param username
     * @return
     */
    public static boolean verify(String token, String username){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            // 在token中附带了username信息
            Verification require = JWT.require(algorithm);
            if (!StringUtils.isEmpty(username)) {
                require.withClaim("username",username);
            }
            JWTVerifier verifier = require.build();
            verifier.verify(token); //认证
            // 认证成功 不抛出异常 返回true
            return true;
        } catch (Exception e) {
            // 认证成功 抛出异常 返回false
            return false;
        }
    }

    /**
     * 获取解码的JWT
     * 用 DecodeJWT的getClaim方法 获取信息
     * @param token
     * @return
     */
    public static DecodedJWT getDecodedJWT(String token){
        try {
            return JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
        }catch (TokenExpiredException e) {
            System.out.println("令牌过期");
        }catch (JWTDecodeException e){
            System.out.println("令牌格式问题");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
