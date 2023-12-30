package com.example.weatherforecast.controllers;

import com.example.weatherforecast.dtos.City;
import com.example.weatherforecast.services.WeatherService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private WeatherService weatherService;

    // Get
    @GetMapping("/cities/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id) {
        return ResponseEntity.ok(id);
    }

    // Post
    @PostMapping
    public ResponseEntity<?> post(@RequestBody final City city) {
        return ResponseEntity.ok(city.getId());
    }

    // Put
    @PutMapping
    public ResponseEntity<?> put(@PathParam(value = "q1") final Long q1,
                                 @PathParam(value = "q2") final String q2) {
        return ResponseEntity.ok(q1);
    }

    // Delete

}
