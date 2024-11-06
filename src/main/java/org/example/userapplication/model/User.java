package org.example.userapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
