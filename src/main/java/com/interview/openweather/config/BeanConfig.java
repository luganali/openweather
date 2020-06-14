package com.interview.openweather.config;

import com.interview.openweather.config.intercepter.ApiKeyParamterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


/*
We created that class because we want to add custom RestTemplate Object to Spring Context
 */
@Configuration
public class BeanConfig {

    @Autowired
    private ApiKeyParamterInterceptor apiKeyParamterInterceptor;

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(apiKeyParamterInterceptor);
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

}
