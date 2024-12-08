package com.example.challengep2.service;

import com.example.challengep2.entity.Priority;
import com.example.challengep2.entity.Task;

import java.util.List;

public interface ItaskService {
    List<Task> getall();

    void addTask(Task c);

    void removetask(Long id);

    List<Task> getTask(String cat, Priority pri);

    Task update(Task t);

    List<Task> Notifications();
}
