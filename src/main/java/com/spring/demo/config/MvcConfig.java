package com.spring.demo.config;

import com.spring.demo.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns(
                        "/ttzj/login",
                        "/register",
                        "/ttzj/register",
                        "/",
                        "/login",
                        "/doRegister",
                        "/login.html",
                        "/error");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main.html").setViewName("ttzj/detail");
        registry.addViewController("/login.html").setViewName("ttzj/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

}
