package com.kt.{{ cookiecutter.package_name }}.exampleUser.controller;

import com.kt.{{ cookiecutter.package_name }}.exampleUser.dto.ExampleUserDto;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.service.ExampleUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "서버 상태 확인", description = "서버가 정상적으로 동작하는지 확인합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "서버 정상 동작 중")
    })
    public ResponseEntity<String> healthCheck() {
        System.out.println("API Call health");
        return ResponseEntity.ok("Server is running");
    }

    @GetMapping
    @Operation(summary = "모든 사용자 조회", description = "시스템에 등록된 모든 사용자 정보를 조회합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    public ResponseEntity<List<ExampleUserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "ID로 사용자 조회", description = "ID에 해당하는 사용자 정보를 조회합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공"),
        @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    public ResponseEntity<ExampleUserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "이메일로 사용자 조회", description = "이메일에 해당하는 사용자 정보를 조회합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공"),
        @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    public ResponseEntity<ExampleUserDto> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping
    @Operation(summary = "사용자 등록", description = "새로운 사용자를 등록합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "등록 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 (중복된 사용자명 또는 이메일)"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    public ResponseEntity<Long> createUser(@RequestBody ExampleUserDto userDto) {
        Long userId = userService.createUser(userDto);
        return ResponseEntity.ok(userId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자 정보 수정", description = "기존 사용자의 정보를 수정합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "수정 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 (중복된 사용자명 또는 이메일)"),
        @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody ExampleUserDto userDto) {
        userService.updateUser(id, userDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "사용자 삭제", description = "ID에 해당하는 사용자를 삭제합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "삭제 성공"),
        @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}