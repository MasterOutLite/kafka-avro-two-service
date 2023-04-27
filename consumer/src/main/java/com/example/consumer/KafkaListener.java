package com.example.consumer;

import com.example.producer.User;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class KafkaListener {
    private final List<User> userList;

    public KafkaListener() {
        this.userList = new ArrayList<>();
    }


    @org.springframework.kafka.annotation.KafkaListener(topics = "my-topic-user", groupId = "my-group")
    public void consumeByte( User user) {
        //System.out.println("User is:" + user);
        //System.out.println("User is:" + user.getName());
        //userList.add(user);
    }

    public User getUserById(Integer id){
        return userList.get(id);
    }

    public Iterator<User> getAllUser(){
        return userList.listIterator();
    }

}
