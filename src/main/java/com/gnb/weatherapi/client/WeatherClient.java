package com.gnb.weatherapi.client;

import com.gnb.weatherapi.dtos.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://api.openweathermap.org/data/2.5/weather", name = "weather-api")
public interface WeatherClient {

    @GetMapping
    ResponseEntity<WeatherResponse> getWeatherByCity(
            @RequestParam String q,
            @RequestParam String appId,
            @RequestParam String units
    );
}
