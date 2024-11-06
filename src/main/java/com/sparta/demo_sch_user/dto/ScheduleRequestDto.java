package com.sparta.demo_sch_user.dto;

import com.sparta.demo_sch_user.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String writer;
    private String title;
    private String description;

    public Schedule toEntity() {
        return new Schedule(
                this.writer,
                this.title,
                this.description
        );
    }
}
