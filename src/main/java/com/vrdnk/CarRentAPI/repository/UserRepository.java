package com.vrdnk.CarRentAPI.repository;

import com.vrdnk.CarRentAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

