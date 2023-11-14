package com.favarao.helpdeskapi.controller;


import com.favarao.helpdeskapi.constant.PathAuthConstant;
import com.favarao.helpdeskapi.dto.AuthLoginDto;
import com.favarao.helpdeskapi.dto.JwtDto;
import com.favarao.helpdeskapi.dto.UserDto;
import com.favarao.helpdeskapi.entity.User;
import com.favarao.helpdeskapi.service.AuthService;
import com.favarao.helpdeskapi.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(PathAuthConstant.BASE_PATH_AUTH)
public class AuthController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;

    public AuthController(
            TokenService tokenService,
            AuthenticationManager authenticationManager,
            AuthService authService
    ) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.authService = authService;
    }

    @PostMapping("/subscribe")
    public JwtDto createUser(@RequestBody @Valid UserDto user, UriComponentsBuilder uriComponentsBuilder){
        UserDto createdUser = this.authService.createUser(user);
        String tokenJwt = this.tokenService.generateToken(createdUser);
        return new JwtDto(tokenJwt);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody AuthLoginDto authLoginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authLoginDto.email(), authLoginDto.password());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        String tokenJwt = this.tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new JwtDto(tokenJwt));
    }
}

