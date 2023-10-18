package com.backend.wantedpreonboardingbackend.employment.application.port.out.repository;

import com.backend.wantedpreonboardingbackend.employment.domain.attend.Attend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendRepo extends JpaRepository<Attend, Long> {
}
