package com.example.sender.Rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class RabbitService {
    @Autowired
    AmqpTemplate template;
    ObjectMapper objectMapper = new ObjectMapper();
    public ResponseEntity<?> createUser(UserModel userModel) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(userModel);
        template.convertAndSend("queueDima", json);
        return new ResponseEntity("Sended Request on user create", HttpStatus.OK);
    }

}
