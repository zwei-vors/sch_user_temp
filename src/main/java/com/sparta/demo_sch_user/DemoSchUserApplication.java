package com.sparta.demo_sch_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DemoSchUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSchUserApplication.class, args);
    }

    // 유저
        // 저장, 조회, 삭제
        // 작성 유저명, 이메일, 작성일, 수정일
        // 일정은 작성 유저명 대신 고유 식별자를 갖는다.
}
