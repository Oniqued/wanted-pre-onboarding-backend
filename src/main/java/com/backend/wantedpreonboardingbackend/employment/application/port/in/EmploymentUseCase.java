package com.backend.wantedpreonboardingbackend.employment.application.port.in;

import com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentReq;
import com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentRes;

import java.util.List;

import static com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentReq.*;
import static com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentRes.*;

public interface EmploymentUseCase {
    void postEmployment(EmploymentPostReq employmentPostReq);

    void updateEmployment(EmploymentUpdateReq employmentUpdateReq);

    void deleteEmployment(Long employmentId);

    List<EmploymentSearchRes> getEmploymentList();

    List<EmploymentSearchRes> getEmploymentSearchResult(String keyword);

    EmploymentDetailRes getEmploymentDetail(Long employmentId);
}
