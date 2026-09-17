package com.example.FoodFleet.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.Filter;

@Component
public class RequestloggingFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {

        String requstId = UUID.randomUUID().toString();

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        httpResponse.setHeader("request-Id", requstId); // give id in response header
        System.out.println("Requst Recived "+ "["+ requstId+ "]"
                + httpRequest.getMethod()+ ""      // method name
                + httpRequest.getRequestURI());   //endpoints

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request,response);
        Long endTime = System.currentTimeMillis();

        long totalTime  = endTime - startTime;
        System.out.println("["+ requstId+ "]"+ "request Complate  "   + totalTime+ "ms");
    }
}
