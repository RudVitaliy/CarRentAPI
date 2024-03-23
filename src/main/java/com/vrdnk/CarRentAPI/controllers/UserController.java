package com.vrdnk.CarRentAPI.controllers;

import com.vrdnk.CarRentAPI.dto.VehicleRentalDto;
import com.vrdnk.CarRentAPI.dto.UserDto;
import com.vrdnk.CarRentAPI.exceptions.EntityErrorResponse;
import com.vrdnk.CarRentAPI.exceptions.EntityExceptionHandler;
import com.vrdnk.CarRentAPI.exceptions.EntityNotCreatedException;
import com.vrdnk.CarRentAPI.mapper.VehicleRentalMapper;
import com.vrdnk.CarRentAPI.mapper.UserMapper;
import com.vrdnk.CarRentAPI.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing user-related operations via RESTful API.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final VehicleRentalMapper vehicleRentalMapper;

    /**
     * Retrieves all users.
     * @return List of UserDto objects representing all clients.
     */
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream().map(userMapper::mapEntityToDto).toList();
    }

    /**
     * Retrieves all rentals of a specific user.
     * @param id The ID of the client whose rentals are to be retrieved.
     * @return List of VehicleRentalDto objects representing all rentals of the specified client.
     */
    @GetMapping("/rentals/{id}")
    public List<VehicleRentalDto> getAllUsersRentals(@PathVariable("id") long id) {
        return userService.getAllClientsRentals(id).stream().map(vehicleRentalMapper::mapEntityToDto).toList();
    }

    /**
     * Registers a new user.
     * @param userDto The DTO object representing the user to be registered.
     * @param bindingResult Object containing any validation errors.
     * @return ResponseEntity indicating the success of the registration operation.
     */
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerUser(
            @RequestBody @Valid UserDto userDto,
            BindingResult bindingResult
    ) {
        EntityExceptionHandler.handleEntityNotCreatedException(bindingResult);
        userService.registerUser(userMapper.mapDtoToEntity(userDto));
        return ResponseEntity.ok(HttpStatus.OK);
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

