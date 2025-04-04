package com.example.schedule.service;

import com.example.schedule.dto.UserRequestDto;
import com.example.schedule.dto.UserResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    // 유저 생성 - 회원가입
    public UserResponseDto createUser(UserRequestDto requestDto) {
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        User user = new User(requestDto.getUserName(), requestDto.getEmail(), requestDto.getPassword());
        User saveUser = userRepository.save(user);
        return new UserResponseDto(saveUser);
    }

    // 전체 유저 조회
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserResponseDto::new).toList();
    }

    // 유저 조회
    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 유저가 없습니다."));
        return new UserResponseDto(user);
    }

    // 유저 수정
    public UserResponseDto putUser(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 유저가 없습니다."));
        if (user.getPassword().equals(requestDto.getPassword())) {
            user.update(requestDto.getUserName());
            User putUser = userRepository.save(user);
            return new UserResponseDto(putUser);
        }
        return null;
    }

    // 유저 삭제
    public void deleteUser(Long id, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 유저가 없습니다."));
        if (user.getPassword().equals(password)) {
            scheduleRepository.deleteByUser(user);
            userRepository.delete(user);
        }
    }
}
