package com.backend.wantedpreonboardingbackend.employment.adapter.out.persistence;

import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.AttendQueryableRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.backend.wantedpreonboardingbackend.employment.domain.attend.QAttend.attend;
import static com.backend.wantedpreonboardingbackend.employment.domain.employment.QEmployment.employment;

@Repository
@RequiredArgsConstructor
public class AttendQueryRepo implements AttendQueryableRepo {
    private final JPAQueryFactory queryFactory;

    @Override
    public boolean isAttendedUser(Long employmentId, Long userId) {
        return false;

//        return queryFactory.selectFrom(attend)
//                .where();
    }
}
