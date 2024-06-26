package org.zuohuang.server.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zuohuang.server.service.Loginservice;

@Configuration
public class config implements WebMvcConfigurer {
    @Autowired
    Loginservice loginservice;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new interceptor(loginservice)).addPathPatterns("/**")
                .excludePathPatterns("/login/**",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v3/api-docs/**",
                        "/v3/api-docs.yaml",
                        "/v3/api-docs.json");
    }
}
