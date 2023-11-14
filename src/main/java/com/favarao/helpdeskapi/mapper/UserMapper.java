package com.favarao.helpdeskapi.mapper;

import com.favarao.helpdeskapi.dto.UserDto;
import com.favarao.helpdeskapi.entity.User;

public class UserMapper {
    public static UserDto entityToDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getUser(), user.getPassword(), user.getRole());
    }

    public static User dtoToUser(UserDto userDto) {
        return new User(userDto.name(), userDto.email(), userDto.user(), userDto.password(), userDto.role());
    }
}
