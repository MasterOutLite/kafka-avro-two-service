package com.example.consumer;

import com.example.producer.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@AllArgsConstructor
public class ControllerConsumer {
    private final KafkaListener kafkaListener;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id) {
        return kafkaListener.getUserById(id);
    }

    @GetMapping("")
    public Iterator<User> getAll() {

        return kafkaListener.getAllUser();
    }
}
