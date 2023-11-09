package com.favarao.helpdeskapi.controller;

import com.favarao.helpdeskapi.entity.User;
import com.favarao.helpdeskapi.dto.UserDto;
import com.favarao.helpdeskapi.repository.UserRepository;
import com.favarao.helpdeskapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list(){
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@Valid @RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> buscarPorId(@PathVariable Long userId) {
        if(!userRepository.existsById(userId)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletar(@PathVariable Long userId){
        if(!userRepository.existsById(userId)) return ResponseEntity.notFound().build();
        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> atualizar(@Valid @PathVariable Long userId,@RequestBody User user){
        //TODO adicionar atualizar
        return null;
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> atualizarParcial(@Valid @PathVariable Long userId,@RequestBody User user){
        //TODO adicionar atualização de senha
        return null;
    }

}
