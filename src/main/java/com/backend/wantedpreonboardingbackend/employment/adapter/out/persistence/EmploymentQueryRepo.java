package com.backend.wantedpreonboardingbackend.employment.adapter.out.persistence;

import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.EmploymentQueryableRepo;
import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public List<Employment> findAllEmployments() {
        return queryFactory.selectFrom(employment)
                .fetch();
    }

    @Override
    public List<Employment> findEmploymentsByKeyword(String keyword) {
        return queryFactory.selectFrom(employment)
                .where(employment.companyId.companyName.contains(keyword)
                        .or(employment.skill.contains(keyword)))
                .fetch();
    }

    @Override
    public List<Long> findEmploymentsWithCompanyId(Long companyId) {
        return queryFactory.select(employment.id).from(employment)
                .where(employment.companyId.id.eq(companyId))
                .fetch();
    }
}
