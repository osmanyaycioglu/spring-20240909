package org.turkcell.trainint.spring.springweb.security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//@WebFilter("/*")
@Order(1)
public class MyFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest servletRequestParam,
                         final ServletResponse servletResponseParam,
                         final FilterChain filterChainParam) throws IOException, ServletException {
        System.out.println("Filter running");
        HttpServletRequest servletRequestLoc = (HttpServletRequest) servletRequestParam;
        String             pathInfoLoc       = servletRequestLoc.getPathInfo();
        String             pathInfoLoc2       = servletRequestLoc.getPathTranslated();
        String             pathInfoLoc3       = servletRequestLoc.getContextPath();
        String             pathInfoLoc4       = servletRequestLoc.getServletPath();
        if (pathInfoLoc4.contains("osman")){
            HttpServletResponse responseLoc = (HttpServletResponse) servletResponseParam;
            responseLoc.getWriter().println("osman path i yasak");
            responseLoc.addHeader("Content-Type", "text/plain");
            return;
        }
        filterChainParam.doFilter(servletRequestParam,
                                  servletResponseParam);
    }
}
