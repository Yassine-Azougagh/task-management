package com.app.task.management.dto;

import com.app.task.management.model.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User,UserDTO> {

    @Override
    public UserDTO apply(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .gender(user.getGender())
                .build();
    }
}
