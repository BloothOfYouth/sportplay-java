package com.hjf.sportplay;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hjf.sportplay.utils.JWTUtils;

/**
 * @author hjf
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test1(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoi5pmu6YCa566h55CG5ZGYIiwiaWQiOiIyIiwiZXhwIjoxNTk5OTMyMzA2LCJlbWFpbCI6IjQ1NkBxcS5jb20iLCJ1c2VybmFtZSI6Im5hdWdodHkifQ.CVKoBBUku9qAz8n2FANblI70c3R8lW4_8NVFmyI5l0s";
        System.out.println(JWTUtils.verify(token, null));
        DecodedJWT decodedJWT = JWTUtils.getDecodedJWT(token);
        Claim admin = decodedJWT.getClaim("username");
        System.out.println(admin.asString());
    }
}
