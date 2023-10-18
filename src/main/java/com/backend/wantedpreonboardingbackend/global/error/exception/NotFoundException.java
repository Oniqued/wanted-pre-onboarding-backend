package com.backend.wantedpreonboardingbackend.global.error.exception;

import com.backend.wantedpreonboardingbackend.global.error.ErrorCode;

public class NotFoundException extends BusinessRuleException{
    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
