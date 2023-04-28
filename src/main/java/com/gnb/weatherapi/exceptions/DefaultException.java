package com.gnb.weatherapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class DefaultException extends RuntimeException {
    private Integer code;
    private String description;
}
