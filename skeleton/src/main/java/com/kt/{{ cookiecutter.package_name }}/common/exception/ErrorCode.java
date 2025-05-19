package com.kt.{{ cookiecutter.package_name }}.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND("해당 사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    DUPLICATE_EMAIL("이미 등록된 이메일입니다.", HttpStatus.BAD_REQUEST),
    VALIDATION_ERROR("유효성 검사에 실패하였습니다.", HttpStatus.BAD_REQUEST),
    INTERNAL_ERROR("서버 내부 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}