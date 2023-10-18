package com.backend.wantedpreonboardingbackend.employment.application.port;

import com.backend.wantedpreonboardingbackend.employment.application.port.in.AttendUseCase;
import com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.AttendReq;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.AttendRepo;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.EmploymentQueryableRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendService implements AttendUseCase {
    private final EmploymentQueryableRepo employmentQueryableRepo;
    private final AttendRepo attendRepo;

    @Override
    public void attend(AttendReq attendReq) {
        
    }
}
