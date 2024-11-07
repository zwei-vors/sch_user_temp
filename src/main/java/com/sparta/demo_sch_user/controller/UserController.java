package com.sparta.demo_sch_user.controller;

import com.sparta.demo_sch_user.dto.UserRequestDto;
import com.sparta.demo_sch_user.dto.UserResponseDto;
import com.sparta.demo_sch_user.entity.User;
import com.sparta.demo_sch_user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("정상적으로 삭제되었습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRequestDto userRequestDto, HttpServletRequest request) {
        User LoginedUser = userService.loginUser(userRequestDto);
        HttpSession session = request.getSession();
        session.setAttribute("SESSION_KEY", LoginedUser.getId());
        System.out.println("loginUser session : " + session);

        return ResponseEntity.ok().body("정상적으로 로그인되었습니다.");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        return ResponseEntity.ok("로그아웃 성공");
    }
}
