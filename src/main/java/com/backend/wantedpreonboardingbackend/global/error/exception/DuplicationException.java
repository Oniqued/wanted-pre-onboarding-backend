package com.backend.wantedpreonboardingbackend.global.error.exception;

import com.backend.wantedpreonboardingbackend.global.error.ErrorCode;

public class DuplicationException extends BusinessRuleException{
    public DuplicationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
