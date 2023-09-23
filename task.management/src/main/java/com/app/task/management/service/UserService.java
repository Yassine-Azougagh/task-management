package com.app.task.management.service;


import com.app.task.management.dto.UserDTO;
import com.app.task.management.dto.UserDTOMapper;
import com.app.task.management.model.User;
import com.app.task.management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserDTOMapper userDTOMapper;

    public Map<String,Object> register(User user){
        Map<String,Object> responseMap = new HashMap<>();
        String username = user.getUsername();
        if(userRepository.findOneByUsername(username).isPresent()){
            responseMap.put("msg","Username already used");
            return responseMap;
        }
        String email = user.getEmail();
        if(userRepository.findOneByEmail(email).isPresent()){
            responseMap.put("msg","Email already used");
            return responseMap;
        }

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
        userRepository.save(user);

        String token = this.generateToken(user.getUsername());
        UserDTO userDTO = userDTOMapper.apply(user);

        responseMap.put("user",userDTO);
        responseMap.put("token",token);
        responseMap.put("status",true);
        return responseMap;

    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }
}
