package com.vrdnk.CarRentAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Date;

/**
 * Entity class representing a vehicle rental, typically stored in a database.
 */
@Entity
@Table(name = "vehicle_rental")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class VehicleRental {

    /** The unique identifier for the rental. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long rentalId;

    /** The user renting the vehicle. */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /** The vehicle being rented. */
    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;

    /** The date when the rental starts. */
    @Column(name = "rental_date")
    private LocalDateTime rentalDate;

    /** The date when the rental ends and the vehicle is returned. */
    @Column(name = "return_date")
    private LocalDateTime returnDate;
}

