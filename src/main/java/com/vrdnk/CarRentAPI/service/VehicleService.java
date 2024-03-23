package com.vrdnk.CarRentAPI.service;

import com.vrdnk.CarRentAPI.exceptions.EntityNotFoundException;
import com.vrdnk.CarRentAPI.model.Vehicle;
import com.vrdnk.CarRentAPI.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class responsible for handling vehicle-related operations.
 */
@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    /**
     * Registers a new vehicle.
     *
     * @param vehicle The vehicle to register.
     */
    @Transactional
    public void registerVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    /**
     * Deletes a vehicle by its ID.
     *
     * @param id The ID of the vehicle to delete.
     * @throws EntityNotFoundException if no vehicle with the specified ID is found.
     */
    @Transactional
    public void deleteVehicle(long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new EntityNotFoundException("Vehicle with id " + id + " not found");
        }
        vehicleRepository.deleteById(id);
    }

    /**
     * Updates information about a vehicle.
     *
     * @param id      The ID of the vehicle to update.
     * @param vehicle The updated information about the vehicle.
     * @throws EntityNotFoundException if no vehicle with the specified ID is found.
     */
    @Transactional
    public void updateVehicle(long id, Vehicle vehicle) {
        if (!vehicleRepository.existsById(id)) {
            throw new EntityNotFoundException("Vehicle with id " + id + " not found");
        }
        vehicle.setId(id);
        vehicleRepository.save(vehicle);
    }

    /**
     * Retrieves a vehicle by its ID.
     *
     * @param id The ID of the vehicle to retrieve.
     * @return The vehicle with the specified ID, or null if not found.
     * @throws EntityNotFoundException if no vehicle with the specified ID is found.
     */
    public Vehicle getVehicleById(long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new EntityNotFoundException("Vehicle with id " + id + " not found");
        }
        return vehicleRepository.findById(id).orElse(null);
    }
}

