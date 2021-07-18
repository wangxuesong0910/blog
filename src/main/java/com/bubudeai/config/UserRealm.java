package com.bubudeai.config;

import com.bubudeai.entity.User;
import com.bubudeai.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 能进入这里说明用户已经通过验证了
        System.out.println("AuthorizationInfo******************");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("AuthenticationInfo##################");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User user = userMapper.queryUser(userToken.getUsername());
        if (user ==null){
            System.out.println("用户为空");
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}