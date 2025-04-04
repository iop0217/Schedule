package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    void deleteByUser(User user);
}