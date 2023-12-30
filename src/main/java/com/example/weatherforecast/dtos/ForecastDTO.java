package com.example.weatherforecast.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForecastDTO {

    private Integer temperature;
    private String  description;

}
