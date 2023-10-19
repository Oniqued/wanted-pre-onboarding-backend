package com.backend.wantedpreonboardingbackend.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum ErrorCode {
    NOT_FOUND_COMPANY(NOT_FOUND, "01001", "해당 회사를 찾을 수 없습니다."),
    NOT_FOUND_EMPLOYMENT_POST(NOT_FOUND, "01002", "해당 채용공고를 찾을 수 없습니다"),
    DUPLICATE_ATTEND(NOT_ACCEPTABLE, "01003", "채용 공고 지원에 대한 중복된 요청입니다."),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ErrorCode(final HttpStatus httpStatus, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}

