package com.itstudent.security;

import org.springframework.core.annotation.Order;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // kiểm tra request có param là password ko?
        // nếu password là: itstudent thì cho qua
        HttpServletResponse rs = (HttpServletResponse) servletResponse;
        String password = servletRequest.getParameter("password");
        if (password != null && password.equals("itstudent"))
            filterChain.doFilter(servletRequest, servletResponse);
        else rs.setStatus(401);
    }
}
