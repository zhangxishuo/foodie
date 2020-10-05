package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class Cors {

    @Bean
    public CorsFilter corsFilter() {
        // 1. 添加cors配置信息
        CorsConfiguration conf = new CorsConfiguration();
        conf.addAllowedOrigin("http://localhost:8080");

        // 设置是否发送cookie信息
        conf.setAllowCredentials(true);

        // 设置允许请求的方式
        conf.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // 设置允许的header
        conf.addAllowedHeader("*");

        // 2. 为url添加映射路径
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**", conf);

        // 3. 返回重新定义好的corsSource
        return new CorsFilter(corsSource);
    }
}
