package com.vrdnk.CarRentAPI.repository;

import com.vrdnk.CarRentAPI.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}

