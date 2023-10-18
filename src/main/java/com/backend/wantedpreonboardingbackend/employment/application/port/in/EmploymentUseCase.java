package com.backend.wantedpreonboardingbackend.employment.application.port.in;

import com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentReq;

import static com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentReq.*;

public interface EmploymentUseCase {
    void postEmployment(EmploymentPostReq employmentPostReq);

    void updateEmployment(EmploymentUpdateReq employmentUpdateReq);

    void deleteEmployment(Long employmentId);
}
