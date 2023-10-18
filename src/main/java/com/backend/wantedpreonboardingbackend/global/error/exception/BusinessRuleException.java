package com.backend.wantedpreonboardingbackend.global.error.exception;

import com.backend.wantedpreonboardingbackend.global.error.ErrorCode;

public class BusinessRuleException extends AbstractErrorException {
    public BusinessRuleException(ErrorCode errorCode) {
        super(errorCode);
    }
}
