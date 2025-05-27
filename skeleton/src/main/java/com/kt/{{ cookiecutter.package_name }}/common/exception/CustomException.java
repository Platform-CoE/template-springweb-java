package com.kt.{{ cookiecutter.package_name }}.common.exception;

import com.kt.{{ cookiecutter.package_name }}.common.exception.ErrorCode;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}