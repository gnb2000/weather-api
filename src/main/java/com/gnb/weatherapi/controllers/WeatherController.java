package com.gnb.weatherapi.controllers;

import com.gnb.weatherapi.dtos.WeatherResponse;
import com.gnb.weatherapi.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weathers")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/city")
    @CrossOrigin(origins = "*")
    public WeatherResponse getWeatherByCity(@RequestParam String city) {
        return weatherService.getWeatherByCity(city);
    }

}
