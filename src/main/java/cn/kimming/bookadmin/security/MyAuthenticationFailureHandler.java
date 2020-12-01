package cn.kimming.bookadmin.security;

import cn.kimming.bookadmin.util.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 刘铭轩KimmingLau
 * @Date: 2020-11-30 11:49
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json; charset=UTF-8");
        System.out.println();
        String jsonString = JSON.toJSONString(new Result(exception.getMessage()));
        response.getWriter().write(jsonString);
    }
}

