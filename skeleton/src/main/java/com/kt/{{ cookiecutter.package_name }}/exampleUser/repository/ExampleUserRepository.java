package com.kt.{{ cookiecutter.package_name }}.exampleUser.repository;

import com.kt.{{ cookiecutter.package_name }}.exampleUser.model.ExampleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExampleUserRepository extends JpaRepository<ExampleUser, Long> {
    Optional<ExampleUser> findByUsername(String username);
    Optional<ExampleUser> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}