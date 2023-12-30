package com.example.weatherforecast.repositories;

import com.example.weatherforecast.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
