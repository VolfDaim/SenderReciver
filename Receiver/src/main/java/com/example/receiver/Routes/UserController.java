package com.example.receiver.Routes;

import com.example.receiver.User.UserModel;
import com.example.receiver.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public Optional<UserModel> findUserById(@PathVariable("id") String id){
        return userService.findUserById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") String id){
        userService.deleteUserById(id);
        return new ResponseEntity("User deleted", HttpStatus.OK);
    }
}
