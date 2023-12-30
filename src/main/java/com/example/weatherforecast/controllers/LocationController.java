package com.example.weatherforecast.controllers;

import com.example.weatherforecast.dtos.LocationDTO;
import com.example.weatherforecast.entities.Location;
import com.example.weatherforecast.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@Slf4j
public class LocationController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private ModelMapper modelMapper;

    // Get location
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id) {

        final Location location = weatherService.getLocation(id);
        return ResponseEntity.ok(location);
    }

    // Create new location
    @PostMapping
    public ResponseEntity<?> post(@RequestBody final LocationDTO locationDTO) {

        log.info("LocationController -> post() called");
        final Location location = modelMapper.map(locationDTO, Location.class);
        final Location createLocation = weatherService.addLocation(location);
        final LocationDTO newLocationDTO = modelMapper.map(createLocation, LocationDTO.class);
        log.info("LocationController -> post() finished");
        return ResponseEntity.ok(newLocationDTO);
    }


    // Update location
    @PutMapping
    public ResponseEntity<?> put(@RequestBody final LocationDTO locationDTO) {

        log.info("LocationController -> put() called");
        final Location updatedLocation = weatherService.updateLocation(locationDTO);
        final LocationDTO updatedLocationDTO = modelMapper.map(updatedLocation, LocationDTO.class);
        log.info("LocationController -> put() finished");
        return ResponseEntity.ok(updatedLocationDTO);
    }

    // Delete location
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        weatherService.deleteLocation(id);
    }
}
