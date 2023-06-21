package com.github.dreamhead.moco.handler.cors;

import com.github.dreamhead.moco.HttpMethod;
import com.github.dreamhead.moco.HttpRequest;
import com.github.dreamhead.moco.MutableHttpResponse;
import com.google.common.base.Joiner;

import java.util.Arrays;

public class CorsMethodsConfig implements CorsConfig {
    private final String[] methods;

    public CorsMethodsConfig(final String[] methods) {
        this.methods = methods;
        ;
    }

    @Override
    public void configure(final HttpRequest httpRequest, final MutableHttpResponse httpResponse) {
        HttpMethod method = httpRequest.getMethod();
        if (Arrays.stream(methods)
                .anyMatch(m -> method.name().equalsIgnoreCase(m))) {
            httpResponse.addHeader("Access-Control-Allow-Methods", Joiner.on(",").join(methods));
        }
    }
}
