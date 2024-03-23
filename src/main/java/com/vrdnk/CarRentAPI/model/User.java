package com.vrdnk.CarRentAPI.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity class representing a user, typically stored in a database.
 */
@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /** The unique identifier for the user. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The name of the user. */
    @Column(name = "name")
    private String name;

    /**
     * The contact information of the user.
     * Should be in international phone number format starting with '+' sign followed by digits,
     * for example, +123456789.
     */
    @Column(name = "contact_info")
    private String contactInfo;

    /** The list of rentals associated with the user. */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<VehicleRental> rentals;
}
