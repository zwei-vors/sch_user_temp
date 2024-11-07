package com.sparta.demo_sch_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Schedule {
    // 작성 유저명, 할일 제목, 할일 내용, 작성일, 수정일
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

    public Schedule(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
    }

    public Schedule() {

    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
