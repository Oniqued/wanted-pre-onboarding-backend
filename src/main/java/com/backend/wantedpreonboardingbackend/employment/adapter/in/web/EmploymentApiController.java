package com.backend.wantedpreonboardingbackend.employment.adapter.in.web;

import com.backend.wantedpreonboardingbackend.employment.adapter.in.web.dto.EmploymentInput;
import com.backend.wantedpreonboardingbackend.employment.application.port.in.EmploymentUseCase;
import com.backend.wantedpreonboardingbackend.global.success.SuccessCode;
import com.backend.wantedpreonboardingbackend.global.success.SuccessResponse;
import com.backend.wantedpreonboardingbackend.global.success.SuccessResponseWithoutResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class EmploymentApiController {
    private final EmploymentUseCase employmentUseCase;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody EmploymentInput.EmploymentPostInput employmentPostInput) {
        employmentUseCase.postEmployment(employmentPostInput.toReq());
        return SuccessResponseWithoutResult.toResponseEntity(SuccessCode.CREATE_EMPLOYMENT_POST_SUCCESS);
    }


}
