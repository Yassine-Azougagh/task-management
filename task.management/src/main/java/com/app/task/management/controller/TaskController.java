package com.app.task.management.controller;


import com.app.task.management.model.Task;
import com.app.task.management.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTasks(){
        return taskService.addTask();
    }


}
