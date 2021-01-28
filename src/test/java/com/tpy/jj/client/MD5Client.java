package com.tpy.jj.client;

import com.tpy.jj.config.shiro.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import sun.nio.ch.DefaultSelectorProvider;

public class MD5Client {

    public static void main(String[] args) {

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        CustomerRealm realm = new CustomerRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);

        defaultSecurityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("tangpengyi","123456");
        subject.login(token);

        Md5Hash md5Hash = new Md5Hash("123456","0dn)DX_q+8I",1024);
        System.out.println(md5Hash.toHex());
    }

}
