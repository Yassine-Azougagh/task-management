package com.app.task.management.repository;

import com.app.task.management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
