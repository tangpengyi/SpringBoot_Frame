package com.tpy.jj.advice;

import com.tpy.jj.api.CommonsResult;
import com.tpy.jj.api.ResponseResult;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * 异常同一管理类
 */
@ControllerAdvice
public class ExceptionResolver {

    /**
     * 权限不足异常捕获
     * @return
     * @throws IOException
     */
    @ResponseBody
    @ExceptionHandler(value = UnauthenticatedException.class)
    public ResponseResult AuthcErrorHandler() throws IOException {
        return CommonsResult.fail(HttpStatus.UNAUTHORIZED.value(),"权限不足");
    }

    @ResponseBody
    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseResult Unauthorized() throws IOException {
        return CommonsResult.fail(HttpStatus.UNAUTHORIZED.value(),"权限不足");
    }

    /**
     *    校验参数异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseResult validationError(MethodArgumentNotValidException ex) {

        FieldError fieldError = ex.getBindingResult().getFieldError();
        String defaultMessage = fieldError.getField() + fieldError.getDefaultMessage();

        return CommonsResult.fail(defaultMessage);
    }

    /**
     * 登录 账号不存在
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = UnknownAccountException.class)
    public ResponseResult UnknownAccount(UnknownAccountException  e) {
        return CommonsResult.fail(HttpStatus.UNAUTHORIZED.value(),"账号不存在");
    }

    /**
     * 登录 密码错误
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public ResponseResult IncorrectCredentials(IncorrectCredentialsException   e) {
        return CommonsResult.fail(HttpStatus.UNAUTHORIZED.value(),"密码错误");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)//处理访问方法时权限不足问题
    public ResponseResult AuthcErrorHandler(Exception e) throws IOException {
        e.printStackTrace();
        return CommonsResult.fail(e.getMessage());
    }
}
