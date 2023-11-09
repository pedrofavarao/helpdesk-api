package com.favarao.helpdeskapi.service;

import com.favarao.helpdeskapi.dto.UserDto;
import com.favarao.helpdeskapi.entity.User;
import com.favarao.helpdeskapi.mapper.UserMapper;
import com.favarao.helpdeskapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto getUser(Long userId){
        User user = userRepository.findById(userId).get();
        return UserMapper.entityToDto(user);
    }
}
