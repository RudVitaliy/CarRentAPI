package com.vrdnk.CarRentAPI.exceptions;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * Class responsible for handling exceptions related to entity creation.
 */
public class EntityExceptionHandler {

    /**
     * Handles exceptions when an entity fails to be created.
     *
     * @param bindingResult The BindingResult containing validation errors.
     * @throws EntityNotCreatedException if there are errors in the BindingResult.
     */
    public static void handleEntityNotCreatedException(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorMsg.append(fieldError.getField())
                        .append(" - ")
                        .append(fieldError.getDefaultMessage())
                        .append(";");
            }
            throw new EntityNotCreatedException(errorMsg.toString());
        }
    }
}

