package com.sparta.demo_sch_user.dto;

import com.sparta.demo_sch_user.entity.User;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String writerName;
    private String email;

    public User toEntity() {
        return new User(
                this.writerName,
                this.email
        )
    }
}
