package com.backend.wantedpreonboardingbackend.employment.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttendReq {
    private Long employmentId;
    private Long userId;


}
