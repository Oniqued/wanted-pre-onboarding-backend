package com.backend.wantedpreonboardingbackend.employment.application.port.out.repository;

import com.backend.wantedpreonboardingbackend.employment.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {

}
