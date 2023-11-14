package com.favarao.helpdeskapi.service;

import com.favarao.helpdeskapi.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface AuthService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
}
