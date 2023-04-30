package com.gnb.weatherapi.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnb.weatherapi.dtos.WeatherResponse;
import com.gnb.weatherapi.exceptions.DefaultException;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class WeatherClient {

    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public WeatherResponse getWeatherByCity(String city) {
        Request request = new Request.Builder()
                .url(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appId=35bc38565794bed9521fe416c6b1708b&units=metrics", city))
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return mapper.readValue(Objects.requireNonNull(response.body()).string(), WeatherResponse.class);
            } else if (response.code() == 404) {
                throw new DefaultException(HttpStatus.NOT_FOUND.value(), "City not found");
            } else {
                throw new DefaultException(HttpStatus.NOT_FOUND.value(), "Internal Server Error");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
