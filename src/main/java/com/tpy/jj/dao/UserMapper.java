package com.tpy.jj.dao;

import com.tpy.jj.entity.Login;
import com.tpy.jj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {

    public int add(User user);

    public List<User> list();

    public User login(String account);

    public List<String> findRolesByUserAccount(String account);

    public List<String> findPermissionByUserAccount(String account);
}
