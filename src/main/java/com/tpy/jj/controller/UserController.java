package com.tpy.jj.controller;

import com.tpy.jj.api.CommonsResult;
import com.tpy.jj.api.ResponseResult;
import com.tpy.jj.entity.Login;
import com.tpy.jj.entity.User;
import com.tpy.jj.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "用户接口",tags = "",description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册用户",httpMethod = "POST",notes = "")
    @PostMapping("register")
    public ResponseResult register(@ApiParam(name = "User",value="json格式",required = true) @RequestBody @Valid User user){
        User new_user = userService.add(user);
        return CommonsResult.success(new_user);
    }

    @RequiresPermissions("user:list")
    @ApiOperation(value="所有用户",httpMethod = "GET",notes = "")
    @GetMapping("/list")
    public ResponseResult list() {
        List<User> list = userService.list();
        return CommonsResult.success(list);
    }

    @RequiresPermissions("user:add")
    @ApiOperation(value="新增用户",httpMethod = "POST",notes = "")
    @PostMapping("/add")
    public ResponseResult add(@ApiParam(name = "User",value="json格式",required = true) @RequestBody @Valid User user){
        User new_user = userService.add(user);
        return new_user == null ? CommonsResult.fail("新增失败"):CommonsResult.success(new_user);
    }

    @PostMapping("/login")
    @ApiOperation(value="登录",httpMethod = "POST",notes = "")
    public ResponseResult login(@ApiParam(name = "Login",value="传入json格式",required=true) @RequestBody @Valid Login login){
        User user = userService.login(login);
        return CommonsResult.success("登录成功",user);
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    @ApiOperation(value="退出登录",httpMethod = "GET",notes = "")
    public ResponseResult loginout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return CommonsResult.success(null);
    }

    @ApiOperation(value="权限不足",httpMethod = "GET",notes = "")
    @GetMapping("/notLogin")
    public ResponseResult notLogin(){
        return CommonsResult.fail(HttpStatus.UNAUTHORIZED.value(),"未登录");
    }
}
