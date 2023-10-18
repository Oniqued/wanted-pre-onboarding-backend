package com.backend.wantedpreonboardingbackend.employment.application.port.in.dto;

import com.backend.wantedpreonboardingbackend.employment.domain.company.Company;
import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import lombok.Builder;
import lombok.Getter;

public class EmploymentReq {

    @Getter
    @Builder
    public static class EmploymentPostReq {
        private Long companyId;
        private String position;
        private Integer reward;
        private String content;
        private String skill;

        public Employment toEntity(Company company) {
            return Employment.createPost(company, position, reward, content, skill);
        }
    }
}
