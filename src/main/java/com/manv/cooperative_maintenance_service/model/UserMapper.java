package com.manv.cooperative_maintenance_service.model;

import com.manv.cooperative_maintenance_service.model.DTO.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDto (User user) {
        return Objects.isNull(user) ? null : modelMapper.map(user, UserDTO.class);
    }

    public User toEntity (UserDTO userDto) {
        return Objects.isNull(userDto) ? null : modelMapper.map(userDto, User.class);
    }
}
