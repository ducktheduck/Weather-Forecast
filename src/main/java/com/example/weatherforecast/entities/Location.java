package com.example.weatherforecast.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity @Table(name = "LOCATION", schema = "weatherforecast")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location extends BaseEntity {

    private String country;
    private String county;
    private String city;
    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Forecast forecast;



}
