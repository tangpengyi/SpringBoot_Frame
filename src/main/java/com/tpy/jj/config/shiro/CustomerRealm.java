package com.tpy.jj.config.shiro;

import com.tpy.jj.dao.UserMapper;
import com.tpy.jj.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

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
        System.out.println("执行授权逻辑");

        //授权代码
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        String principal =(String) subject.getPrincipal();

        //从数据库获取权限字符串
        String str = "user:list";
        info.addStringPermission(str);

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
        log.info("执行登录操作");
        if(login == null){
            return null;
        }
        //判断密码是否正确
        return new SimpleAuthenticationInfo(principal,login.getPwd(), new MyByteSource(login.getSalt()),this.getName());
    }

}
