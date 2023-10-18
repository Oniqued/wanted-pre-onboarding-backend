package com.backend.wantedpreonboardingbackend.employment.application.port;

import com.backend.wantedpreonboardingbackend.employment.application.port.in.EmploymentUseCase;
import com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentRes;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.CompanyQueryableRepo;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.EmploymentQueryableRepo;
import com.backend.wantedpreonboardingbackend.employment.application.port.out.repository.EmploymentRepo;
import com.backend.wantedpreonboardingbackend.employment.domain.company.Company;
import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import com.backend.wantedpreonboardingbackend.global.error.ErrorCode;
import com.backend.wantedpreonboardingbackend.global.error.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentReq.*;
import static com.backend.wantedpreonboardingbackend.employment.application.port.in.dto.EmploymentRes.*;

@Service
@RequiredArgsConstructor
public class EmploymentService implements EmploymentUseCase {
    private final EmploymentQueryableRepo employmentQueryableRepo;
    private final EmploymentRepo employmentRepo;
    private final CompanyQueryableRepo companyQueryableRepo;

    @Override
    public void postEmployment(EmploymentPostReq employmentPostReq) {
        Company company = companyQueryableRepo.findCompanyByCompanyId(employmentPostReq.getCompanyId())
                .orElseThrow(()->new NotFoundException(ErrorCode.NOT_FOUND_COMPANY));

        Employment newEmployment = employmentRepo.save(employmentPostReq.toEntity(company));
    }

    @Override
    @Transactional
    public void updateEmployment(EmploymentUpdateReq employmentUpdateReq) {
        Employment employment = employmentQueryableRepo.findEmploymentByEmploymentId(employmentUpdateReq.getEmploymentId())
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_EMPLOYMENT_POST));

        employment.updatePost(employmentUpdateReq);
    }

    @Override
    @Transactional
    public void deleteEmployment(Long employmentId) {
        Employment employment = employmentQueryableRepo.findEmploymentByEmploymentId(employmentId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_EMPLOYMENT_POST));

        employmentRepo.delete(employment);
    }

    @Override
    public List<EmploymentSearchRes> getEmploymentList() {
        List<Employment> employmentList = employmentQueryableRepo.findAllEmployments();

        return employmentList.stream().map(employment -> EmploymentSearchRes.of(employment)).toList();
    }

    @Override
    public List<EmploymentSearchRes> getEmploymentSearchResult(String keyword) {
        List<Employment> employmentList = employmentQueryableRepo.findEmploymentsByKeyword(keyword);

        return employmentList.stream().map(employment -> EmploymentSearchRes.of(employment)).toList();
    }

    @Override
    public EmploymentDetailRes getEmploymentDetail(Long employmentId) {
        Employment employment = employmentQueryableRepo.findEmploymentByEmploymentId(employmentId)
                .orElseThrow(()->new NotFoundException(ErrorCode.NOT_FOUND_EMPLOYMENT_POST));
        List<Long> anotherEmployment = employmentQueryableRepo.findEmploymentsWithCompanyId(employment.getCompanyId().getId());

        return EmploymentDetailRes.of(employment, anotherEmployment);
    }
}
