package com.vrdnk.CarRentAPI.repository;

import com.vrdnk.CarRentAPI.model.VehicleRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRentalRepository extends JpaRepository<VehicleRental, Long> {
}


