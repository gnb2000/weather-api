package com.gnb.weatherapi.services;

import com.gnb.weatherapi.client.WeatherClient;
import com.gnb.weatherapi.dtos.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    @Value("${openweathermap.apikey}")
    private String apiKey;

    public WeatherResponse getWeatherByCity(String city) {
        return weatherClient.getWeatherByCity(city);
    }
}
