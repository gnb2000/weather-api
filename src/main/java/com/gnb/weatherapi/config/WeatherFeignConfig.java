package com.gnb.weatherapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnb.weatherapi.client.WeatherFeignErrorDecoder;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherFeignConfig {

    private final ObjectMapper objectMapper;

    @Bean
    public ErrorDecoder errorDecoder() {
        return new WeatherFeignErrorDecoder(objectMapper);
    }
}
