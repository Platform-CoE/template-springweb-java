package com.kt.{{ cookiecutter.package_name }}.sampleUser.controller;

import com.kt.{{ cookiecutter.package_name }}.sampleUser.dto.UserDto;
import com.kt.{{ cookiecutter.package_name }}.sampleUser.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User API", description = "사용자 관련 API")
public class UserController {

    private final UserService userService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
    	System.out.println("API Call health");
        return ResponseEntity.ok("Server is running");
    }

    @GetMapping
    @Operation(summary = "모든 사용자 조회", description = "시스템에 등록된 모든 사용자 정보를 조회합니다.")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "특정 사용자 조회", description = "ID에 해당하는 사용자 정보를 조회합니다.")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
} 