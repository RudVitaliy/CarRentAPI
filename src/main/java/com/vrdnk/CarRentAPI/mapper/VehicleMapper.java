package com.vrdnk.CarRentAPI.mapper;


import com.vrdnk.CarRentAPI.dto.VehicleDto;
import com.vrdnk.CarRentAPI.model.Vehicle;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Vehicle entities and VehicleDto objects.
 */
@Mapper(componentModel = "spring")
public interface VehicleMapper {

    /**
     * Converts a Vehicle entity to a VehicleDto object.
     *
     * @param vehicle The Vehicle entity to convert.
     * @return The converted VehicleDto object.
     */
    VehicleDto mapEntityToDto(Vehicle vehicle);

    /**
     * Converts a VehicleDto object to a Vehicle entity.
     *
     * @param vehicleDto The VehicleDto object to convert.
     * @return The converted Vehicle entity.
     */
    Vehicle mapDtoToEntity(VehicleDto vehicleDto);
}

