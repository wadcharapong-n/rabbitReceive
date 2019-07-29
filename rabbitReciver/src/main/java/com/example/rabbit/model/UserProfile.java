package com.example.rabbit.model;

import com.example.rabbit.config.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
public class UserProfile implements Serializable {

    @Id
    @JsonSerialize(using= ObjectIdSerializer.class)
    private ObjectId id;
    private String firstName;
    private String lastName;
}
