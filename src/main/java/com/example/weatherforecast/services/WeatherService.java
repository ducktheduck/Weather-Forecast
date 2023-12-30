package com.example.weatherforecast.services;

import com.example.weatherforecast.dtos.LocationDTO;
import com.example.weatherforecast.entities.Forecast;
import com.example.weatherforecast.entities.Location;
import com.example.weatherforecast.repositories.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class WeatherService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Location getLocation(final Long id) {

        return locationRepository.findById(id).orElse(null);
    }

    public Location addLocation(final Location location) {
        if (location.getForecast() != null) {
            final Forecast forecast = location.getForecast();
            forecast.setLocation(location);
        }
        return locationRepository.save(location);
    }

    public Location updateLocation(final LocationDTO locationDTO) {
        final Optional<Location> optionalLocation = locationRepository.findById(locationDTO.getId());
        if (optionalLocation.isPresent()) {
            final Location location = optionalLocation.get();
            modelMapper.map(locationDTO, location);
            return locationRepository.save(location);
        }
        return null;
    }
    public void deleteLocation(final Long id) {
        locationRepository.deleteById(id);
    }
}
