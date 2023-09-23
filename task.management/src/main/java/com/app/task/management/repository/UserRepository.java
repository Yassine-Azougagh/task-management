package com.app.task.management.repository;

import com.app.task.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findOneByUsername(String username);

    Optional<User> findOneByEmail(String email);
}
