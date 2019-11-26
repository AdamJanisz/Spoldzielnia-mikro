package com.adammateusz.spoldzielniamikro;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.js/**").addResourceLocations("/src/main/webapp/ui/static/");
        registry.addResourceHandler("/*.css/**").addResourceLocations("/src/main/webapp/ui/static/");
    }

}
