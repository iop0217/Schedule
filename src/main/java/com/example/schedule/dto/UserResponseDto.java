package com.example.schedule.dto;

import com.example.schedule.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long userId;
    private String userName;
    private LocalDateTime createDate;

    public UserResponseDto(User user) {
        this.userId = user.getId();
        this.userName = user.getUserName();
        this.createDate = user.getCreateDate();
    }
}
