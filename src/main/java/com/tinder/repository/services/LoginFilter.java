package com.tinder.repository.services;


import com.tinder.repository.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebFilter(urlPatterns = "/login")
public class LoginFilter implements Filter {

    private User userCredentials;

    public void setUserCredentials(User userCredentials) {
        this.userCredentials = userCredentials;
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        String userName = servletRequest.getParameter("inputEmail");
        String password = servletRequest.getParameter("inputPassword");
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;

        UserService userService = new UserService();
        try {
            setUserCredentials(userService.getUsersCredentials(userName,password));
            System.out.println(userCredentials.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(userName != null && password != null){
            servletRequest1.getSession();
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            servletResponse1.setStatus(401);
            servletResponse1.getWriter().print("wrong credentials");
        }
    }

    @Override
    public void destroy() {
    }
}


