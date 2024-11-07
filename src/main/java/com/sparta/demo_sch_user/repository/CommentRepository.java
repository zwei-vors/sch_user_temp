package com.sparta.demo_sch_user.repository;

import com.sparta.demo_sch_user.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countByScheduleId(Long scheduleId);
}
