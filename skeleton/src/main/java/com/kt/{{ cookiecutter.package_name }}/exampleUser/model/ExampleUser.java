package com.kt.{{cookiecutter.package_name}}.exampleUser.model;

import com.kt.{{cookiecutter.package_name}}.common.model.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "example_users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleUser extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;
}