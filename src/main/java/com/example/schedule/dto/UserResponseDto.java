package com.example.schedule.dto;

import com.example.schedule.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long id;
    private String userName;
    private LocalDateTime createDate;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.createDate = user.getCreateDate();
    }
}
