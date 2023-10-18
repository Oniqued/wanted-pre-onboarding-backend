package com.backend.wantedpreonboardingbackend.employment.application.port.out.repository;

import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;

import java.util.List;
import java.util.Optional;

public interface EmploymentQueryableRepo {
    Optional<Employment> findEmploymentByEmploymentId(Long employmentId);
    List<Employment> findAllEmployments();
    List<Employment> findEmploymentsByKeyword(String keyword);
    List<Long> findEmploymentsWithCompanyId(Long companyId, Long employmentId);
}
