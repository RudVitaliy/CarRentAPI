package com.vrdnk.CarRentAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a vehicle, stored in a database.
 */
@Entity
@Table(name = "Vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    /** The unique identifier for the vehicle. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The brand of the vehicle. */
    @Column(name = "brand")
    private String brand;

    /** The model of the vehicle. */
    @Column(name = "model")
    private String model;

    /** The year of manufacture of the vehicle. */
    @Column(name = "year_of_manufacture")
    private int yearOfManufacture;

    /** The color of the vehicle. */
    @Column(name = "color")
    private String color;

    /** The mileage of the vehicle. */
    @Column(name = "mileage")
    private int mileage;
}
