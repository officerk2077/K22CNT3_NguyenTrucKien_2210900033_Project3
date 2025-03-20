package com.ntk.ntk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/home/**")
                .addResourceLocations("classpath:/static/home/");
        registry.addResourceHandler("/admin.**")
                .addResourceLocations("classpath:/static/admin/");
    }
}