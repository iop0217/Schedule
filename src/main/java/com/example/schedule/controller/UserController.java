package com.example.schedule.controller;

import com.example.schedule.dto.UserRequestDto;
import com.example.schedule.dto.UserResponseDto;
import com.example.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 유저 생성 - 회원가입
    @PostMapping("/signup")
    public UserResponseDto signup(@RequestBody UserRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    // 전체 유저 조회
    @GetMapping
    public List<UserResponseDto> getUsers() {
        return userService.getUsers();
    }

    // 유저 조회
    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    // 유저 수정
    @PutMapping("/{id}")
    public UserResponseDto putUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        return userService.putUser(id, requestDto);
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id, @RequestBody String password) {
        userService.deleteUser(id, password);
        return ResponseEntity.ok("유저가 삭제되었습니다.");
    }
}
