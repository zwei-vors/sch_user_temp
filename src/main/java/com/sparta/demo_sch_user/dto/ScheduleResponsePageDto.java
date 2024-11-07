package com.sparta.demo_sch_user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponsePageDto {
    private String title;
    private String description;
    private int commentCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String writerName;

    public ScheduleResponsePageDto(String title, String description, int commentCount, LocalDateTime createdAt, LocalDateTime modifiedAt, String writerName) {
        this.title = title;
        this.description = description;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.writerName = writerName;
    }
}
