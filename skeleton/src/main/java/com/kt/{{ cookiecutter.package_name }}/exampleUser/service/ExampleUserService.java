package com.kt.{{ cookiecutter.package_name }}.exampleUser.service;

import com.kt.{{ cookiecutter.package_name }}.exampleUser.dto.ExampleUserDto;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.model.ExampleUser;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.repository.ExampleUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExampleUserService {
    private final ExampleUserRepository userRepository;

    public List<ExampleUserDto> findAll() {
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ExampleUserDto findById(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Transactional
    public Long createUser(ExampleUserDto userDto) {
        validateUserCreation(userDto);
        ExampleUser user = convertToEntity(userDto);
        ExampleUser savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Transactional
    public void updateUser(Long id, ExampleUserDto userDto) {
        ExampleUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        validateUserUpdate(user, userDto);
        updateUserFromDto(user, userDto);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    private ExampleUserDto convertToDto(ExampleUser user) {
        return ExampleUserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .enabled(user.isEnabled())
                .build();
    }

    private ExampleUser convertToEntity(ExampleUserDto dto) {
        return ExampleUser.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword()) // 실제 구현에서는 비밀번호 암호화 필요
                .role(dto.getRole())
                .enabled(dto.isEnabled())
                .build();
    }

    private void updateUserFromDto(ExampleUser user, ExampleUserDto dto) {
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            user.setPassword(dto.getPassword()); // 실제 구현에서는 비밀번호 암호화 필요
        }
        user.setRole(dto.getRole());
        user.setEnabled(dto.isEnabled());
    }

    private void validateUserCreation(ExampleUserDto dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists: " + dto.getUsername());
        }
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists: " + dto.getEmail());
        }
    }

    private void validateUserUpdate(ExampleUser existingUser, ExampleUserDto dto) {
        if (!existingUser.getUsername().equals(dto.getUsername()) && 
            userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists: " + dto.getUsername());
        }
        if (!existingUser.getEmail().equals(dto.getEmail()) && 
            userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists: " + dto.getEmail());
        }
    }
}