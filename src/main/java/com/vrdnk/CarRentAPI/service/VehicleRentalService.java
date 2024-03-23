package com.vrdnk.CarRentAPI.service;

import com.vrdnk.CarRentAPI.model.VehicleRental;
import com.vrdnk.CarRentAPI.model.User;
import com.vrdnk.CarRentAPI.repository.VehicleRentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Service class responsible for handling vehicle rental operations.
 */
@Service
@RequiredArgsConstructor
public class VehicleRentalService {

    private final VehicleRentalRepository vehicleRentalRepository;
    private final UserService userService;
    private final VehicleService vehicleService;

    /**
     * Rents a vehicle to a user.
     *
     * @param userId    The ID of the user renting the vehicle.
     * @param vehicleId The ID of the vehicle being rented.
     */
    public void rentTheVehicle(long userId, long vehicleId) {
        User user = userService.getUserById(userId);
        LocalDateTime currentDateTime = LocalDateTime.now();
        VehicleRental rental = new VehicleRental().toBuilder()
                .vehicle(vehicleService.getVehicleById(vehicleId))
                .user(user)
                .rentalDate(currentDateTime)
                .build();
        user.getRentals().add(rental);
        vehicleRentalRepository.save(rental);
    }
}

