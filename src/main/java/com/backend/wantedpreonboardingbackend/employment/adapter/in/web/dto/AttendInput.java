package com.backend.wantedpreonboardingbackend.employment.adapter.in.web.dto;

import com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.AttendReq;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttendInput {
    private Long employmentId;
    private Long userId;

    public static AttendReq toReq(Long employmentId, Long userId) {
        return AttendReq.builder()
                .employmentId(employmentId)
                .userId(userId)
                .build();
    } 
}
