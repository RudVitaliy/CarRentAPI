package com.vrdnk.CarRentAPI.mapper;


import com.vrdnk.CarRentAPI.dto.VehicleRentalDto;
import com.vrdnk.CarRentAPI.model.VehicleRental;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between VehicleRental entities and VehicleRentalDto objects.
 */
@Mapper(componentModel = "spring")
public interface VehicleRentalMapper {

    /**
     * Converts a VehicleRental entity to a VehicleRentalDto object.
     *
     * @param vehicleRental The VehicleRental entity to convert.
     * @return The converted VehicleRentalDto object.
     */
    VehicleRentalDto mapEntityToDto(VehicleRental vehicleRental);

    /**
     * Converts a VehicleRentalDto object to a VehicleRental entity.
     *
     * @param vehicleRentalDto The VehicleRentalDto object to convert.
     * @return The converted VehicleRental entity.
     */
    VehicleRental mapDtoToEntity(VehicleRentalDto vehicleRentalDto);
}

