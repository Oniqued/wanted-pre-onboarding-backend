package com.backend.wantedpreonboardingbackend.employment.adapter.out.persistence;

import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.EmploymentQueryableRepo;
import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.backend.wantedpreonboardingbackend.employment.domain.employment.QEmployment.employment;

@Repository
@RequiredArgsConstructor
public class EmploymentQueryRepo implements EmploymentQueryableRepo {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Employment> findEmploymentByEmploymentId(Long employmentId) {
        return Optional.ofNullable(
                queryFactory.selectFrom(employment)
                        .where(employment.id.eq(employmentId))
                        .fetchOne()
        );
    }
}
