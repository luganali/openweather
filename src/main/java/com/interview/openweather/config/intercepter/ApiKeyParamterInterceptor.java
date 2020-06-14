package com.interview.openweather.config.intercepter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@Component
public class ApiKeyParamterInterceptor implements ClientHttpRequestInterceptor {

    @Value("${openweather.api.key}")
    private String apiKEY;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        URI uri = UriComponentsBuilder.fromHttpRequest(request)
                .queryParam("appid", apiKEY)
                .build().toUri();

        HttpRequest modifiedRequest = new HttpRequestWrapper(request) {

            @Override
            public URI getURI() {
                return uri;
            }
        };
        return execution.execute(modifiedRequest, body);
    }

}