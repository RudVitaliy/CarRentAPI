package com.vrdnk.CarRentAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing user data for transfer over the network.
 */
@Data
public class UserDto {

    /** The name of the user. */
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    /**
     * The contact information of the user.
     * Should be in international phone number format starting with '+' sign followed by digits,
     * for example, +123456789.
     */
    @NotEmpty(message = "Contact info cannot be empty")
    @JsonProperty("contact_info")
    @Pattern(regexp = "^\\+[1-9]\\d{1,14}$", message = "Contact info should be in international phone number format starting with '+' sign followed by digits, for example, +123456789")
    private String contactInfo;
}

