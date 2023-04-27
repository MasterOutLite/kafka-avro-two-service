package com.example.producer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ControllerProducer {

    private final KafkaTemplate<String, User> kafkaTemplateByte;

    @PostMapping()
    public void postUser(){

        User user = new User();
        user.setId(23);
        user.setName("Producer");

        kafkaTemplateByte.send("my-topic-user",user);

    }

    @GetMapping("get")
    public String getUser(){
        User user = new User();
        user.setId(23);
        user.setName("Producer");

        kafkaTemplateByte.send("my-topic-user",user);
        return user.getName();
    }
}
