package org.turkcell.trainint.spring.springweb.security;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//@WebServlet("/deneme/yanilma")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req,
                         final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Servlet running !!!!!!!!!!!!!!");
        resp.getWriter().println("deneme yanilmanin GET methodunu cağırdınız");
        resp.addHeader("Content-Type", "text/plain");
    }

    @Override
    protected void doPost(final HttpServletRequest req,
                          final HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("deneme yanilmanin POST methodunu cağırdınız");
        resp.addHeader("Content-Type", "text/plain");
    }
}
