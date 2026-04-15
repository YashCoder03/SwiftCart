package com.order.order.config;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignConfig {
    
    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {

            HttpServletRequest request = attributes.getRequest();

            String authorization = request.getHeader("Authorization");
            String userId = request.getHeader("X-User-Id");
            if (authorization != null) {
                requestTemplate.header("Authorization", authorization);
            }

            if (userId != null) {
                requestTemplate.header("X-User-Id", userId);
            }

        }
        };
    }
}
