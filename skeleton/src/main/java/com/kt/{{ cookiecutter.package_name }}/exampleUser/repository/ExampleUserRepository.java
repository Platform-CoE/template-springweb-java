package com.kt.{{ cookiecutter.package_name }}.exampleUser.repository;

import com.kt.{{ cookiecutter.package_name }}.exampleUser.model.ExampleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ExampleUserRepository extends JpaRepository<ExampleUser, Long> {
    List<ExampleUser> findAll();
    Optional<ExampleUser> findById(Long id);
    Optional<ExampleUser> findByEmail(String email);
}