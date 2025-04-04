package com.example.schedule.dto;

import lombok.Getter;
import lombok.NonNull;

@Getter
@NonNull
public class UserRequestDto {
    private String userName;
    private String email;
    private String password;
}
