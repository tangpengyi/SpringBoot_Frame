package com.tpy.jj.service.Impl;

import com.tpy.jj.dao.UserMapper;
import com.tpy.jj.entity.Login;
import com.tpy.jj.entity.User;
import com.tpy.jj.service.UserService;
import com.tpy.jj.utils.Commons;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public User add(User user) {

        String salt = Commons.getSalt(new Random().nextInt(20));
        user.setSalt(salt);

        Md5Hash md5Hash = new Md5Hash(user.getPwd(), salt, 1024);
        user.setPwd(md5Hash.toHex());

        int add = userMapper.add(user);
        return add < 1 ? null:user;
    }

    @Override
    public User login(Login login) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(login.getAccount(), login.getPwd());
        subject.login(token);
        return null;
    }
}
