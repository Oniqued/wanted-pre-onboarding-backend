package com.backend.wantedpreonboardingbackend.employment.application.port.in;

import com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.AttendReq;

public interface AttendUseCase {
    void attend(AttendReq attendReq);
}
