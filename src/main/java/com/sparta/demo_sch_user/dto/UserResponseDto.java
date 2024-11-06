package com.sparta.demo_sch_user.dto;

import com.sparta.demo_sch_user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long id;
    private String writerName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public UserResponseDto(Long id, String writerName, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.writerName = writerName;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getWriterName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }
}
