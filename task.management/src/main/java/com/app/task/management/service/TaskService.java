package com.app.task.management.service;

import com.app.task.management.model.Task;
import com.app.task.management.model.TaskStatus;
import com.app.task.management.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task addTask(){
        Task task = Task.builder()
                .title("task")
                .description("desc")
                .dueDate(new Date())
                .status(TaskStatus.TODO)
                .build();
        return taskRepository.save(task);
    }
}
