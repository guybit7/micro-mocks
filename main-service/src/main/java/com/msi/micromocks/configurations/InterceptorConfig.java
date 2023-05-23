package com.msi.micromocks.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.msi.micromocks.interceptors.ControllerRegistrarInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final ControllerRegistrarInterceptor customInterceptor;

    @Autowired
    public InterceptorConfig(ControllerRegistrarInterceptor customInterceptor) {
        this.customInterceptor = customInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor)
                .addPathPatterns("/**");
    }

	
}
