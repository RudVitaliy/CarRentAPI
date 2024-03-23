package com.vrdnk.CarRentAPI.service;


import com.vrdnk.CarRentAPI.exceptions.EntityNotFoundException;
import com.vrdnk.CarRentAPI.model.VehicleRental;
import com.vrdnk.CarRentAPI.model.User;
import com.vrdnk.CarRentAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Service class responsible for handling user-related operations.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Registers a new user.
     *
     * @param user The user to register.
     */
    @Transactional
    public void registerUser(User user) {
        userRepository.save(user);
    }

    /**
     * Retrieves all users.
     *
     * @return A list of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID, or null if not found.
     * @throws EntityNotFoundException if no user with the specified ID is found.
     */
    public User getUserById(long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves all rentals associated with a specific user.
     *
     * @param id The ID of the user whose rentals to retrieve.
     * @return A list of rentals associated with the specified user, or an empty list if no rentals are found.
     */
    public List<VehicleRental> getAllClientsRentals(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<VehicleRental> rentals = user.getRentals();
            if (rentals != null) {
                return rentals;
            } else {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }
    }
}

