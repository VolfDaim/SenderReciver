package com.example.sender.Rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {
    @Autowired
    private RabbitService rabbitService;

    public RabbitController(RabbitService rabbitService){
        this.rabbitService = rabbitService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) throws JsonProcessingException {
        return rabbitService.createUser(userModel);
    }
}
