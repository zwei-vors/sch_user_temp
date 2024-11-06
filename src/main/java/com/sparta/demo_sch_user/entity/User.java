package com.sparta.demo_sch_user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writerName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public User() {}

    public User(String writerName, String email) {

    }
}
