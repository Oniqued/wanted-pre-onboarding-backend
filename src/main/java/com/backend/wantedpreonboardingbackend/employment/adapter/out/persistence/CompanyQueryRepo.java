package com.backend.wantedpreonboardingbackend.employment.adapter.out.persistence;

import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.CompanyQueryableRepo;
import com.backend.wantedpreonboardingbackend.employment.domain.company.Company;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.backend.wantedpreonboardingbackend.employment.domain.company.QCompany.company;

@Repository
@RequiredArgsConstructor
public class CompanyQueryRepo implements CompanyQueryableRepo {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Company> findCompanyByCompanyId(Long companyId) {
        return Optional.ofNullable(
                queryFactory.selectFrom(company)
                        .where(company.id.eq(companyId))
                        .fetchOne()
        );
    }
}
