package com.gnb.weatherapi.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnb.weatherapi.dtos.WeatherErrorResponse;
import com.gnb.weatherapi.exceptions.DefaultException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WeatherFeignErrorDecoder implements ErrorDecoder {
    private final ObjectMapper mapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        WeatherErrorResponse message = null;

        try (InputStream bodyIs = response.body().asInputStream()) {
            message = mapper.readValue(bodyIs, WeatherErrorResponse.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        return switch (response.status()) {
            case 400 -> new DefaultException(HttpStatus.BAD_REQUEST.value(), message.getMessage());
            case 404 -> new DefaultException(HttpStatus.NOT_FOUND.value(), message.getMessage());
            default -> new DefaultException(HttpStatus.INTERNAL_SERVER_ERROR.value(), message.getMessage());
        };
    }
}
