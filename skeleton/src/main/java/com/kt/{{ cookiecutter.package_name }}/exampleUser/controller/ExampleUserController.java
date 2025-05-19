package com.kt.{{ cookiecutter.package_name }}.exampleUser.controller;

import com.kt.{{ cookiecutter.package_name }}.exampleUser.dto.ExampleUserDto;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.service.ExampleUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/example/users")
@RequiredArgsConstructor
@Tag(name = "User API Example", description = "사용자 관련 API 예시")
public class ExampleUserController {

    private final ExampleUserService userService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
    	System.out.println("API Call health");
        return ResponseEntity.ok("Server is running");
    }

    @GetMapping
    @Operation(summary = "모든 사용자 조회", description = "시스템에 등록된 모든 사용자 정보를 조회합니다.")
    public ResponseEntity<List<ExampleUserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "특정 사용자 조회", description = "ID에 해당하는 사용자 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ResponseEntity<ExampleUserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "특정 사용자 조회", description = "이메일에 해당하는 사용자 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ResponseEntity<ExampleUserDto> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping("/register")
    @Operation(summary = "사용자 등록", description = "새로운 사용자를 등록합니다")
    public ResponseEntity<?> registerUser(@RequestBody @Valid ExampleUserRegistrationRequestDto request) {
        userService.register(request);
        return ResponseEntity.ok().build();
    }
}