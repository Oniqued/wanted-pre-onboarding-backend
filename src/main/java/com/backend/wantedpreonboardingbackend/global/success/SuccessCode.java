package com.backend.wantedpreonboardingbackend.global.success;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {
    CREATE_EMPLOYMENT_POST_SUCCESS(HttpStatus.OK, "0100", "채용 공고 등록 성공"),
    UPDATE_EMPLOYNENT_POST_SUCCESS(HttpStatus.OK, "0101", "채용 공고 수정 성공"),
    DELETE_EMPLOYMENT_POST_SUCCESS(HttpStatus.OK, "0102", "채용 공고 삭제 성공"),
    GET_EMPLOYMENT_POST_SUCCESS(HttpStatus.OK, "0103", "채용 공고 조회 성공"),
    ATTEND_SUCCESS(HttpStatus.OK, "0104", "채용공고 지원 성공"),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    SuccessCode(final HttpStatus httpStatus, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
