package com.backend.wantedpreonboardingbackend.employment.adapter.in.web.dto;

import com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentReq;
import lombok.Builder;
import lombok.Getter;

import static com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentReq.*;

public class EmploymentInput {

    @Getter
    @Builder
    public static class EmploymentPostInput {
        private Long companyId;
        private String position;
        private Integer reward;
        private String content;
        private String skill;

        public EmploymentPostReq toReq(){
            return EmploymentPostReq.builder()
                    .companyId(companyId)
                    .position(position)
                    .reward(reward)
                    .content(content)
                    .skill(skill)
                    .build();
        }
    }
}
