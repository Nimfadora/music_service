package com.vasylieva.music_service.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Profile("default")
@Configuration
@PropertySource("classpath:application.properties")
class ApplicationConfig {

    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}