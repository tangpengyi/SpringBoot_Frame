package com.tpy.jj.config.shiro;

import com.tpy.jj.dao.UserMapper;
import com.tpy.jj.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //授权代码
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        String principal =(String) subject.getPrincipal();

        List<String> permissions = userMapper.findPermissionByUserAccount(principal);
        List<String> roles = userMapper.findRolesByUserAccount(principal);

        info.addStringPermissions(permissions);
        info.addRoles(roles);
        return info;
    }

    /**
     * 执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String principal = (String) token.getPrincipal();
        User login = userMapper.login(principal);

        if(login == null){
            return null;
        }
        //判断密码是否正确
        return new SimpleAuthenticationInfo(principal,login.getPwd(), new MyByteSource(login.getSalt()),this.getName());
    }

}
