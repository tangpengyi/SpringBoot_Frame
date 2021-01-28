package com.tpy.jj.filter;

import com.tpy.jj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class ResponseResultInterceptor implements HandlerInterceptor {

    private final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("访问地址==="+request.getRequestURI());

        return true;
    }

}
