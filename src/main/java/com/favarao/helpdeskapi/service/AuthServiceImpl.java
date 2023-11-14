package com.favarao.helpdeskapi.service;

import com.favarao.helpdeskapi.dto.UserDto;
import com.favarao.helpdeskapi.entity.User;
import com.favarao.helpdeskapi.mapper.UserMapper;
import com.favarao.helpdeskapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        try {
            User user = UserMapper.dtoToUser(userDto);
            user.setPassword(passwordEncoder.encode(userDto.password()));

            User userCreated = this.userRepository.save(user);
            return new UserDto(userCreated.getId(), userCreated.getName(), userCreated.getEmail(), userCreated.getUser(), userCreated.getPassword(), userCreated.getRole());
        } catch (Exception e) {
            throw new RuntimeException("Error to create user. " + e.getMessage());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found!"));
    }
}
