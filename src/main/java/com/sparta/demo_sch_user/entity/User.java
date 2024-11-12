package com.sparta.demo_sch_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String writerName;
    private String email;
    private String password;

    public User() {}

    public User(String writerName, String email, String password) {
        this.writerName = writerName;
        this.email = email;
        this.password = password;
    }
}
