package com.backend.wantedpreonboardingbackend.employment.application.port.out.repository;

import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentRepo extends JpaRepository<Employment, Long> {

}
