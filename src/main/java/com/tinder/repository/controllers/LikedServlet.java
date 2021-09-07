package com.tinder.repository.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LikedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.getWriter().print("Hello");
        resp.setContentType("text/html");
        // can't find correct way for project
        RequestDispatcher view = req.getRequestDispatcher("/people-list.html");

        try {
            view.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
