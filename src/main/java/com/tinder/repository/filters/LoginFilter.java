package com.tinder.repository.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        String userName = servletRequest.getParameter("inputEmail");
        String password = servletRequest.getParameter("inputPassword");
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
        if(userName != null && password != null){
            servletRequest1.getSession();
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            servletResponse1.setStatus(401);
            servletResponse1.getWriter().print("");
        }
    }

    @Override
    public void destroy() {
    }
}

