package com.itstudent.security;

import com.itstudent.repository.interfac.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@AllArgsConstructor
public class JWTFilter implements Filter {
    private UserRepository userRepository;
    private JWTService jwtService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse rs = (HttpServletResponse) servletResponse;
        String token = servletRequest.getParameter("token");
        if (token != null) {
            String username = jwtService.decode(token);
            if (username != null && userRepository.existsByUsernameAndDeletedFalse(username))
                filterChain.doFilter(servletRequest, servletResponse);
            else rs.setStatus(401);
        } else rs.setStatus(401);
    }
}
