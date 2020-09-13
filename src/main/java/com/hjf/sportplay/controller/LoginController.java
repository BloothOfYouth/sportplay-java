package com.hjf.sportplay.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.hjf.sportplay.entity.Easyuser;
import com.hjf.sportplay.model.ResultMap;
import com.hjf.sportplay.service.IEasyuserService;
import com.hjf.sportplay.utils.JWTUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * @author hjf
 */
@RestController
public class LoginController {

    @Autowired
    private IEasyuserService easyuserService;

    @Autowired
    private ResultMap resultMap;

    /**
     * 登录
     * @param easyuser 登录请求的请求体(post)
     * @return
     */
    @PostMapping("/login")
    public ResultMap login(@RequestBody Easyuser easyuser){
        System.out.println("easyuser = " + easyuser);
        Easyuser realEasyuser = easyuserService.selectByUsernameAndPassword(easyuser.getUsername(), easyuser.getPassword());
        if (realEasyuser == null) {
            return resultMap.fail().code(401).message("用户名或密码错误");
        }else{

            if (realEasyuser.getRole().equals("普通用户") && !realEasyuser.getState()) {
                return resultMap.fail().code(401).message("用户以被封号");
            }

            HashMap<String, String> claims = new HashMap<>();
            claims.put("email",realEasyuser.getEmail());
            claims.put("role",realEasyuser.getRole());
            claims.put("id",realEasyuser.getId().toString());
            return resultMap.success().code(200).message(JWTUtils.getToken(claims, realEasyuser.getUsername()));
        }
    }

    /**
     * 非法请求跳转
     * @param message
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return resultMap.success().code(401).message(message);
    }

    /**
     * 令牌验证
     * @param token
     * @return
     */
    @PostMapping("/tokenVerity")
    public HashMap<String, Object> tokenVerity(String token){
        System.out.println(token);
        System.out.println("令牌验证");
        DecodedJWT decodedJWT = JWTUtils.getDecodedJWT(token);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("role",decodedJWT.getClaim("role").asString());
        hashMap.put("id",decodedJWT.getClaim("id").asString());
        return hashMap;
    }
}
