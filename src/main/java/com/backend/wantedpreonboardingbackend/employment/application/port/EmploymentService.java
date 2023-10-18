package com.backend.wantedpreonboardingbackend.employment.application.port;

import com.backend.wantedpreonboardingbackend.employment.application.port.in.EmploymentUseCase;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.CompanyQueryableRepo;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.EmploymentRepo;
import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentReq.*;

@Service
@RequiredArgsConstructor
public class EmploymentService implements EmploymentUseCase {
    private final EmploymentRepo employmentRepo;
    private final CompanyQueryableRepo companyQueryableRepo;

    @Override
    public void postEmployment(EmploymentPostReq employmentPostReq) {

    }
}
