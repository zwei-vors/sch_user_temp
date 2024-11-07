package com.sparta.demo_sch_user.repository;

import com.sparta.demo_sch_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
