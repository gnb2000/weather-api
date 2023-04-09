package com.gnb.weatherapi.controllers;

import com.gnb.weatherapi.dtos.WeatherResponse;
import com.gnb.weatherapi.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weathers")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/city")
    public WeatherResponse getWeatherByCity(@RequestParam String city) {
        return weatherService.getWeatherByCity(city);
    }

}
