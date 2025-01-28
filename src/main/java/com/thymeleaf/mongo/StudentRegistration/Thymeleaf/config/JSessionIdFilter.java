package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class JSessionIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String url = httpRequest.getRequestURL().toString();

        if (url.contains(";jsessionid")) {

            String cleanUrl = url.replaceAll(";jsessionid=.*$", "");
            System.out.println("here");
            httpResponse.sendRedirect(cleanUrl);

            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
