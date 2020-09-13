package com.hjf.sportplay.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjf.sportplay.dao.EasyuserDao;
import com.hjf.sportplay.entity.Easyuser;
import com.hjf.sportplay.utils.JWTUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hjf
 */
@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private EasyuserDao easyuserDao;

    /**
     * 为了让realm支持jwt的凭证校验
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限授权————");
        String username = JWTUtils.getDecodedJWT(principalCollection.toString()).getClaim("username").asString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        QueryWrapper<Easyuser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        String role = easyuserDao.selectOne(wrapper).getRole();
        //每个用户可以设置新的权限
        Set<String> roleSet = new HashSet<>();
        //需要将 role, permission 封装到 Set 作为 info.setRoles()
        roleSet.add(role);
        //设置该用户拥有的角色和权限
        info.setRoles(roleSet);
        return info;
    }

    /**
     * 认证
     * 登录认证校验
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtils.getDecodedJWT(token).getClaim("username").asString();
        if (username == null || !JWTUtils.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
        QueryWrapper<Easyuser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Easyuser easyuser = easyuserDao.selectOne(queryWrapper);
        if (easyuser == null) {
            throw new AuthenticationException("该用户不存在！");
        }
        Boolean state = easyuser.getState();
        if (easyuser.getRole().equals("普通用户") && state == false) {
            throw new AuthenticationException("该用户已被封号！");
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }
}
