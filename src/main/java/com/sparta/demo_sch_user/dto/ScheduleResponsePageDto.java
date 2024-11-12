package com.sparta.demo_sch_user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponsePageDto {
    private final String title;
    private final String description;
    private final int commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String writerName;

    public ScheduleResponsePageDto(String title, String description, int commentCount, LocalDateTime createdAt, LocalDateTime modifiedAt, String writerName) {
        this.title = title;
        this.description = description;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.writerName = writerName;
    }
}
