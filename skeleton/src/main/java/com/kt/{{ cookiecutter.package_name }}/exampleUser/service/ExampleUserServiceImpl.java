package com.kt.{{ cookiecutter.package_name }}.exampleUser.service;

import com.kt.{{ cookiecutter.package_name }}.exampleUser.dto.ExampleUserDto;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.dto.ExampleUserRegistrationRequestDto;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.mapper.ExampleUserMapper;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.model.ExampleUser;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.repository.ExampleUserRepository;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.service.ExampleUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExampleUserServiceImpl implements ExampleUserService {
    private final ExampleUserRepository userRepository;
    private final ExampleUserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ExampleUserDto> findAll() {
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ExampleUserDto findById(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public ExampleUserDto findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional
    public void register(ExampleUserRegistrationRequestDto request) {
        userMapper.insert(request);
    }

    private ExampleUserDto convertToDto(ExampleUser user) {
        return ExampleUserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}