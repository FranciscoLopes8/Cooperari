package com.github.FranciscoLopes8.cooperari.repository;

import com.github.FranciscoLopes8.cooperari.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
