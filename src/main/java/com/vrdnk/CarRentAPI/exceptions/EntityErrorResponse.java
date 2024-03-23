package com.vrdnk.CarRentAPI.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an error response for entities to be sent to the client.
 */
@Getter
@Setter
@AllArgsConstructor
public class EntityErrorResponse {

    /**
     * The error message.
     */
    private String message;

    /**
     * The timestamp when the error occurred.
     */
    private long timestamp;
}
