package com.sparta.demo_sch_user.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private Long userId;
    private String title;
    private String description;
}
