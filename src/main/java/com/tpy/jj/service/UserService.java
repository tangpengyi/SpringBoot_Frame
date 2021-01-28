package com.tpy.jj.service;

import com.tpy.jj.entity.Login;
import com.tpy.jj.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<User> list();

    public User add(User user);

    public User login(Login login);
}
