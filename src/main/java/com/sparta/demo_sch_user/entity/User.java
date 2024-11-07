package com.sparta.demo_sch_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String writerName;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public User() {}

    public User(String writerName, String email, String password) {
        this.writerName = writerName;
        this.email = email;
        this.password = password;
    }
}
