package com.sparta.demo_sch_user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Schedule {
    // 작성 유저명, 할일 제목, 할일 내용, 작성일, 수정일
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Schedule(String writer, String title, String description) {
        this.writer = writer;
        this.title = title;
        this.description = description;
    }

    public Schedule() {

    }

    public void update(String writer, String title, String description) {
        this.writer = writer;
        this.title = title;
        this.description = description;
    }
}
