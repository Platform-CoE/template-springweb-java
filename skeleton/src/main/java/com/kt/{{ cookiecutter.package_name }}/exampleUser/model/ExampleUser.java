package com.kt.{{ cookiecutter.package_name }}.exampleUser.model;

import com.kt.{{ cookiecutter.package_name }}.common.model.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "example_users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleUser extends BaseEntity{

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = true;

    @Column(nullable = false, length = 20)
    @Builder.Default
    private String role = "USER";
}