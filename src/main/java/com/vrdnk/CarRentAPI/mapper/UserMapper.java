package com.vrdnk.CarRentAPI.mapper;


import com.vrdnk.CarRentAPI.dto.UserDto;
import com.vrdnk.CarRentAPI.model.User;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between User entities and UserDto objects.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Converts a User entity to a UserDto object.
     *
     * @param user The User entity to convert.
     * @return The converted UserDto object.
     */
    UserDto mapEntityToDto(User user);

    /**
     * Converts a UserDto object to a User entity.
     *
     * @param userDto The UserDto object to convert.
     * @return The converted User entity.
     */
    User mapDtoToEntity(UserDto userDto);
}


