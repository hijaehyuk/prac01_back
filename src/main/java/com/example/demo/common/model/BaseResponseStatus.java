package com.example.demo.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BaseResponseStatus {
    // 2000번대 성공
    SUCCESS(true, 2000, "요청 성공"),

    // 3000번대 클라이언트 입력 오류, 입력값 검증 오류
    JWT_EXPIRED(false, 3001, "JWT 토큰 만료"),
    JWT_INVALID(false, 3002, "JWT 토큰 유효하지 않음"),
    SIGNUP_DUPLICATE_EMAIL(false, 3003, "중복된 이메일"),
    SIGNUP_INVALID_PASSWORD(false, 3004, "비밀번호는 대소문자, 숫자, 특수문자 포함"),

    // 5000번대 실패
    FAIL(false, 5000, "요청 실패");

    private final boolean success;
    private final int code;
    private final String message;
}
