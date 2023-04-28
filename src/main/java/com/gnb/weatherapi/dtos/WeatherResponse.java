package com.gnb.weatherapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private String name;
    private String base;
    private Long visibility;
    private Main main;
    private Cloud clouds;
    private Wind wind;
    private Long dt;

    @Data
    public static class Main {
        private Float temp;

        @JsonProperty("feels_like")
        private Float feelsLike;

        @JsonProperty("temp_min")
        private Float tempMin;

        @JsonProperty("temp_max")
        private Float tempMax;

        private Integer pressure;
        private Integer humidity;
    }

    @Data
    public static class Cloud {
        private Integer all;
    }

    @Data
    public static class Wind {
        private Float speed;
        private Integer deg;
    }
}
