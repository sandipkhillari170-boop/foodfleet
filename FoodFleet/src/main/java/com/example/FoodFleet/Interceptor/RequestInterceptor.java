package com.example.FoodFleet.Interceptor;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest httpRequest,
                             HttpServletResponse httpResponse,
                             Object handler){
        System.out.println("Interceptor : " +httpRequest.getMethod()+" "
        +httpRequest.getRequestURI());

        return true;
    }
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView){
        System.out.println("Controller execution complate !");
    }
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception e){
        System.out.println(" AFTER COMPLITION LOOK HERE");
    }

}
