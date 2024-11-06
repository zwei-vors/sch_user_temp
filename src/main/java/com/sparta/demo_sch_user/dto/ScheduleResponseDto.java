package com.sparta.demo_sch_user.dto;

import com.sparta.demo_sch_user.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String writer;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long id, String writer, String title, String description, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getWriter(),
                schedule.getTitle(),
                schedule.getDescription(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );

    }
}
