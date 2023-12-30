package com.example.weatherforecast.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDTO {

    private Long id;
    private String country;
    private String county;
    private String city;
    private ForecastDTO forecast;

}
