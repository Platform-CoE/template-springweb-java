package com.kt.{{ cookiecutter.package_name }}.sampleUser.repository;

import com.kt.{{ cookiecutter.package_name }}.sampleUser.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(Long id);
} 