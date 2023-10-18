package com.backend.wantedpreonboardingbackend.employment.application.port.in.dto;

import com.backend.wantedpreonboardingbackend.employment.domain.company.Company;
import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class EmploymentRes {
    @Getter
    @Builder
    public static class EmploymentSearchRes {
        private Long employmentId;
        private String companyName;
        private String nation;
        private String state;
        private String position;
        private Integer reward;
        private String skill;

        public static EmploymentSearchRes of(Employment employment) {
            return EmploymentSearchRes.builder()
                    .employmentId(employment.getId())
                    .companyName(employment.getCompanyId().getCompanyName())
                    .nation(employment.getCompanyId().getNation())
                    .state(employment.getCompanyId().getState())
                    .position(employment.getPosition())
                    .reward(employment.getReward())
                    .skill(employment.getSkill())
                    .build();
        }
    }

    @Getter
    @Builder
    public static class EmploymentDetailRes {
        private Long employmentId;
        private String companyName;
        private String nation;
        private String state;
        private String position;
        private Integer reward;
        private String skill;
        private String content;
        private List<Long> anotherEmployments;

        public static EmploymentDetailRes of(Employment employment, List<Long> anotherEmployments) {
            return EmploymentDetailRes.builder()
                    .employmentId(employment.getId())
                    .companyName(employment.getCompanyId().getCompanyName())
                    .nation(employment.getCompanyId().getNation())
                    .state(employment.getCompanyId().getState())
                    .position(employment.getPosition())
                    .reward(employment.getReward())
                    .skill(employment.getSkill())
                    .content(employment.getContent())
                    .anotherEmployments(anotherEmployments)
                    .build();
        }
    }
}
