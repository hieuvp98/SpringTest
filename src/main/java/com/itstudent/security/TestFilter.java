package com.itstudent.security;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import java.io.IOException;

@Order(1)
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
