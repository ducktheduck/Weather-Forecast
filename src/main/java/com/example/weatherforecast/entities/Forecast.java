package com.example.weatherforecast.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Forecast", schema = "weatherforecast")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forecast extends BaseEntity{

    private Integer temperature;
    private String  description;

    @OneToOne
    @JoinColumn(name = "location_id")
    @JsonBackReference
    private Location location;

}
