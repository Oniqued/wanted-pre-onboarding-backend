package com.backend.wantedpreonboardingbackend.employment.application.port.out.repository;

public interface AttendQueryableRepo {
    boolean isAttendedUser(Long employmentId, Long userId);
}
