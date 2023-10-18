package com.backend.wantedpreonboardingbackend.employment.application.port.out.repository;

import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;

import java.util.Optional;

public interface EmploymentQueryableRepo {
    Optional<Employment> findEmploymentByEmploymentId(Long employmentId);
}
