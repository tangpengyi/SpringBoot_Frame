package com.tpy.jj.service;

import com.tpy.jj.entity.Login;
import com.tpy.jj.entity.User;

import java.util.List;

public interface UserService {

    public List<User> list();

    public User add(User user);

    public User login(Login login);

    public List<String> getRoleByUserAccount(String accout);

    public List<String> findPermissionByUserAccount(String accout);
}
