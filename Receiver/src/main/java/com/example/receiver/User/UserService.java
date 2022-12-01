package com.example.receiver.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@EnableRabbit
@Component
public class UserService implements UserInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    AmqpTemplate template;

    ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "queueDima")
    public void createUser(String in) throws JsonProcessingException {
        UserModel userModel = objectMapper.readValue(in, UserModel.class);
        userRepository.save(userModel);
        System.out.println(in);
    }

    @Override
    public Optional<UserModel> findUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
