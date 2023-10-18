package com.backend.wantedpreonboardingbackend.employment.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;

public class CompanyRes {

    @Getter
    @Builder
    public static class CompanySearchRes {
        private String companyName;
        private String nation;
        private String state;
    }
}
