package com.example.rabbit;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class UserProfile implements Serializable {

    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
}
