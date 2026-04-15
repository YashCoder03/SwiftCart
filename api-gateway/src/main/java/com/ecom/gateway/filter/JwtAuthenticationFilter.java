package com.ecom.gateway.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements GlobalFilter {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String auth = exchange.getRequest()
                                .getHeaders()
                                .getFirst(HttpHeaders.AUTHORIZATION);
        
        if(auth == null || !auth.startsWith("Bearer ")){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        String token = auth.substring(7);
        try {
            Claims claims = Jwts.parserBuilder()
                                .setSigningKey(secret.getBytes())
                                .build()
                                .parseClaimsJws(token)
                                .getBody();

            String userId = claims.getSubject();
            String role = claims.get("role",String.class);
            String email= claims.get("email",String.class);
            String id= claims.get("id",String.class);
            System.out.println("UserId "+ userId);

            ServerHttpRequest modifiedRequest = exchange.getRequest()
                                                        .mutate()
                                                        .header("X-User-Email", email)
                                                        .header("X-User-Role", role)
                                                        .header("X-User-Id", id)
                                                        .build();

            return chain.filter(exchange.mutate().request(modifiedRequest).build());

        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }

    

    
}
