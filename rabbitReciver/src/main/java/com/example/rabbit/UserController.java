package com.example.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageSender sender;

    @PostMapping("/user")
    public ResponseEntity addUser(){
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName("menkung");
        userProfile.setLastName("Iris");
        userRepository.insert(userProfile);
        sender.addUser(userProfile);
        return ResponseEntity.ok().body(userProfile);
    }

}
