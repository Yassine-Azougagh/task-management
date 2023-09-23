package com.app.task.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "t_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Date dueDate;
    private TaskStatus status;
}
