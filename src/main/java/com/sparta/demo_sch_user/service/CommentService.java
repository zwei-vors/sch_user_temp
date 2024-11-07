package com.sparta.demo_sch_user.service;

import com.sparta.demo_sch_user.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Long countByScheduleId(Long scheduleId) {
        return commentRepository.countByScheduleId(scheduleId);
    }
}
