package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private UserResponseDto user;
    private String title;
    private String contents;
    private LocalDateTime createDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.user = new UserResponseDto(schedule.getUser());
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createDate = schedule.getCreateDate();
    }
}
