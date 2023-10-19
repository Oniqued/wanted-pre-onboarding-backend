package com.backend.wantedpreonboardingbackend.employment.application.port;

import com.backend.wantedpreonboardingbackend.employment.application.port.in.AttendUseCase;
import com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.AttendReq;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.AttendQueryableRepo;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.AttendRepo;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.EmploymentQueryableRepo;
import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import com.backend.wantedpreonboardingbackend.global.error.ErrorCode;
import com.backend.wantedpreonboardingbackend.global.error.exception.DuplicationException;
import com.backend.wantedpreonboardingbackend.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttendService implements AttendUseCase {
    private final EmploymentQueryableRepo employmentQueryableRepo;
    private final AttendRepo attendRepo;
    private final AttendQueryableRepo attendQueryableRepo;

    @Override
    public void attend(AttendReq attendReq) {
        if (attendQueryableRepo.isAttendedUser(attendReq.getEmploymentId(), attendReq.getUserId())) {
            throw new DuplicationException(ErrorCode.DUPLICATE_ATTEND);
        }
        Employment employment = employmentQueryableRepo.findEmploymentByEmploymentId(attendReq.getEmploymentId())
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_EMPLOYMENT_POST));

        attendRepo.save(attendReq.toEntity(employment));
    }
}
