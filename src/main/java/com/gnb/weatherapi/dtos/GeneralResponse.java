package com.gnb.weatherapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class GeneralResponse {
    private Integer code;
    private String description;
}
