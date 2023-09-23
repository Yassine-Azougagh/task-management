package com.app.task.management.dto;

import com.app.task.management.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Gender gender;
}
