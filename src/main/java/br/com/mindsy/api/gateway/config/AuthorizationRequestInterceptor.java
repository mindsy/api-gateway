package br.com.mindsy.api.gateway.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthorizationRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        System.out.println("PATH: " + template.path());
    }
}
