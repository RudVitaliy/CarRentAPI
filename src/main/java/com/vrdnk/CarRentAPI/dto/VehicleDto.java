package com.vrdnk.CarRentAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing vehicle data for transfer over the network.
 */
@Data
public class VehicleDto {

    /** The brand of the vehicle. */
    @NotEmpty(message = "Brand cannot be empty")
    private String brand;

    /** The model of the vehicle. */
    @NotEmpty(message = "Model cannot be empty")
    private String model;

    /** The year of manufacture of the vehicle. */
    @NotNull(message = "Year of manufacture cannot be null")
    @JsonProperty("year_of_manufacture")
    private int yearOfManufacture;

    /** The color of the vehicle. */
    @NotEmpty(message = "Color cannot be empty")
    private String color;

    /** The mileage of the vehicle. */
    @NotNull(message = "Mileage cannot be null")
    private int mileage;
}
