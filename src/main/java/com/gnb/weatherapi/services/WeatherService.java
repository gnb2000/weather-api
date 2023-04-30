package com.gnb.weatherapi.services;

import com.gnb.weatherapi.client.WeatherFeignClient;
import com.gnb.weatherapi.dtos.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherFeignClient weatherFeignClient;

    @Value("${openweathermap.apikey}")
    private String apiKey;

    public WeatherResponse getWeatherByCity(String city) {
        return weatherFeignClient.getWeatherByCity(city, apiKey, "metrics").getBody();
    }
}
