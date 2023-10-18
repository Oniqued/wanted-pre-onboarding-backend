package com.backend.wantedpreonboardingbackend.employment.application.port.out.repository;

import com.backend.wantedpreonboardingbackend.employment.domain.company.Company;

import java.util.Optional;

public interface CompanyQueryableRepo {
    Optional<Company> findCompanyByCompanyId(Long companyId);
}
