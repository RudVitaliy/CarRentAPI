package com.vrdnk.CarRentAPI.controllers;

import com.vrdnk.CarRentAPI.dto.VehicleDto;
import com.vrdnk.CarRentAPI.exceptions.EntityErrorResponse;
import com.vrdnk.CarRentAPI.exceptions.EntityExceptionHandler;
import com.vrdnk.CarRentAPI.exceptions.EntityNotCreatedException;
import com.vrdnk.CarRentAPI.exceptions.EntityNotFoundException;
import com.vrdnk.CarRentAPI.mapper.VehicleMapper;
import com.vrdnk.CarRentAPI.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing vehicle-related operations via RESTful API.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleMapper vehicleMapper;

    /**
     * Registers a new vehicle.
     * @param vehicleDto The DTO object representing the vehicle to be registered.
     * @param bindingResult Object containing any validation errors.
     * @return ResponseEntity indicating the success of the registration operation.
     */
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerVehicle(
            @RequestBody @Valid VehicleDto vehicleDto,
            BindingResult bindingResult
    ) {
        EntityExceptionHandler.handleEntityNotCreatedException(bindingResult);
        vehicleService.registerVehicle(vehicleMapper.mapDtoToEntity(vehicleDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Deletes a vehicle by its ID.
     * @param vehicleId The ID of the vehicle to be deleted.
     * @return ResponseEntity indicating the success of the deletion operation.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteVehicle(
            @PathVariable("id") int vehicleId
    ) {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Updates details of a vehicle.
     * @param vehicleDto The DTO object representing the updated details of the vehicle.
     * @param bindingResult Object containing any validation errors.
     * @param id The ID of the vehicle to be updated.
     * @return ResponseEntity indicating the success of the update operation.
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> update (
            @RequestBody @Valid VehicleDto vehicleDto,
            BindingResult bindingResult,
            @PathVariable("id") long id
    ) {
        EntityExceptionHandler.handleEntityNotCreatedException(bindingResult);
        vehicleService.updateVehicle(id, vehicleMapper.mapDtoToEntity(vehicleDto));
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

    /**
     * Handles exceptions related to entity not created.
     * @param vehicleNotCreatedException The exception indicating entity not created.
     * @return ResponseEntity containing error response and HTTP status indicating bad request.
     */
    @ExceptionHandler
    private ResponseEntity<EntityErrorResponse> handleException(EntityNotCreatedException vehicleNotCreatedException) {
        EntityErrorResponse vehicleErrorResponse = new EntityErrorResponse(
                vehicleNotCreatedException.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(vehicleErrorResponse, HttpStatus.BAD_REQUEST);
    }
}

