package com.gnb.weatherapi.exceptions;

import com.gnb.weatherapi.dtos.GeneralResponse;
import com.gnb.weatherapi.dtos.WeatherResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<GeneralResponse> handleDefaultException(DefaultException ex) {
        return new ResponseEntity<>(
                GeneralResponse.builder()
                        .code(ex.getCode())
                        .description(ex.getDescription())
                        .build(),
                HttpStatusCode.valueOf(ex.getCode())
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponse> handleException(Exception ex) {
        return new ResponseEntity<>(
                GeneralResponse.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .description(ex.getMessage())
                        .build(),
                HttpStatusCode.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())
        );
    }
}
