package com.vrdnk.CarRentAPI.dto;

import com.vrdnk.CarRentAPI.model.User;
import com.vrdnk.CarRentAPI.model.Vehicle;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Data Transfer Object (DTO) representing vehicle rental data for transfer over the network.
 */
@Data
@Builder(toBuilder = true)
public class VehicleRentalDto {

    /** The user renting the vehicle. */
    private User user;

    /** The vehicle being rented. */
    private Vehicle vehicle;

    /** The date when the rental starts. */
    private Date rentalDate;

    /** The date when the rental ends and the vehicle is returned. */
    private Date returnDate;
}


