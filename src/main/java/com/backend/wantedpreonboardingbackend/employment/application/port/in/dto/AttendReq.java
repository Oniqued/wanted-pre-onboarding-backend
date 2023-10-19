package com.backend.wantedpreonboardingbackend.employment.application.port.in.dto;

import com.backend.wantedpreonboardingbackend.employment.domain.attend.Attend;
import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttendReq {
    private Long employmentId;
    private Long userId;

    public Attend toEntity(Employment employmentId) {
        return Attend.createAttend(employmentId, userId);
    }
}
