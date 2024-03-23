package com.vrdnk.CarRentAPI.controllers;


import com.vrdnk.CarRentAPI.exceptions.EntityErrorResponse;
import com.vrdnk.CarRentAPI.exceptions.EntityNotFoundException;
import com.vrdnk.CarRentAPI.service.VehicleRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing vehicle rental operations via RESTful API.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rent")
public class VehicleRentalController {

    private final VehicleRentalService rentalService;

    /**
     * Handles the rental of a vehicle by a client.
     * @param clientId The ID of the client renting the vehicle.
     * @param vehicleId The ID of the vehicle to be rented.
     * @return ResponseEntity indicating the success of the rental operation.
     */
    @PostMapping()
    public ResponseEntity<HttpStatus> rentTheVehicle(
            @RequestParam(name = "client_id") long clientId,
            @RequestParam(name = "vehicle_id") long vehicleId
    ) {
        rentalService.rentTheVehicle(clientId, vehicleId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Handles exceptions related to entity not found.
     * @param entityNotFoundException The exception indicating entity not found.
     * @return ResponseEntity containing error response and HTTP status indicating not found.
     */
    @ExceptionHandler
    private ResponseEntity<EntityErrorResponse> handleException(EntityNotFoundException entityNotFoundException) {
        EntityErrorResponse vehicleErrorResponse = new EntityErrorResponse(
                entityNotFoundException.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(vehicleErrorResponse, HttpStatus.NOT_FOUND);
    }
}

