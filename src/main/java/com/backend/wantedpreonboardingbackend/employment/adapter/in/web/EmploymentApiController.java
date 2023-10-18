package com.backend.wantedpreonboardingbackend.employment.adapter.in.web;

import com.backend.wantedpreonboardingbackend.employment.adapter.in.web.dto.AttendInput;
import com.backend.wantedpreonboardingbackend.employment.adapter.in.web.dto.EmploymentInput;
import com.backend.wantedpreonboardingbackend.employment.application.port.in.AttendUseCase;
import com.backend.wantedpreonboardingbackend.employment.application.port.in.EmploymentUseCase;
import com.backend.wantedpreonboardingbackend.global.success.SuccessCode;
import com.backend.wantedpreonboardingbackend.global.success.SuccessResponse;
import com.backend.wantedpreonboardingbackend.global.success.SuccessResponseWithoutResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.backend.wantedpreonboardingbackend.employment.adapter.in.web.dto.EmploymentInput.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class EmploymentApiController {
    private final EmploymentUseCase employmentUseCase;
    private final AttendUseCase attendUseCase;

    @Operation(summary = "채용공고 등록 API", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessResponseWithoutResult.class)))
    })
    @PostMapping
    public ResponseEntity<?> post(@RequestBody EmploymentPostInput employmentPostInput) {
        employmentUseCase.postEmployment(employmentPostInput.toReq());
        return SuccessResponseWithoutResult.toResponseEntity(SuccessCode.CREATE_EMPLOYMENT_POST_SUCCESS);
    }

    @Operation(summary = "채용공고 수정 API", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessResponseWithoutResult.class)))
    })
    @PutMapping("/{employmentId}")
    public ResponseEntity<?> update(@PathVariable Long employmentId, @RequestBody EmploymentUpdateInput employmentUpdateInput) {
        employmentUseCase.updateEmployment(employmentUpdateInput.toReq(employmentId));
        return SuccessResponseWithoutResult.toResponseEntity(SuccessCode.UPDATE_EMPLOYNENT_POST_SUCCESS);
    }

    @Operation(summary = "채용공고 삭제 API", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessResponseWithoutResult.class)))
    })
    @DeleteMapping("/{employmentId}")
    public ResponseEntity<?> delete(@PathVariable Long employmentId) {
        employmentUseCase.deleteEmployment(employmentId);
        return SuccessResponseWithoutResult.toResponseEntity(SuccessCode.DELETE_EMPLOYMENT_POST_SUCCESS);
    }

    @Operation(summary = "채용공고 전체 조회 API", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessResponseWithoutResult.class)))
    })
    @GetMapping("/all")
    public ResponseEntity<SuccessResponse> getAllPosts() {
        return SuccessResponse.toResponseEntity(SuccessCode.GET_EMPLOYMENT_POST_SUCCESS, employmentUseCase.getEmploymentList());
    }

    @Operation(summary = "채용공고 조건 검색 API", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessResponseWithoutResult.class)))
    })
    @GetMapping
    public ResponseEntity<SuccessResponse> searchPosts(@RequestParam(name = "search") String keyword) {
        return SuccessResponse.toResponseEntity(SuccessCode.GET_EMPLOYMENT_POST_SUCCESS, employmentUseCase.getEmploymentSearchResult(keyword));
    }

    @Operation(summary = "채용공고 상세보기 API", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessResponseWithoutResult.class)))
    })
    @GetMapping("/{employmentId}")
    public ResponseEntity<SuccessResponse> getEmploymentDetail(@PathVariable Long employmentId) {
        return SuccessResponse.toResponseEntity(SuccessCode.GET_EMPLOYMENT_POST_SUCCESS, employmentUseCase.getEmploymentDetail(employmentId));
    }

    @Operation(summary = "채용공고 지원 API", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessResponseWithoutResult.class)))
    })
    @PostMapping("/{employmentId}/attend")
    public ResponseEntity<?> attendEmployment(@PathVariable Long employmentId, @RequestParam Long userId) {
        attendUseCase.attend(AttendInput.toReq(employmentId, userId));
        return SuccessResponseWithoutResult.toResponseEntity(SuccessCode.ATTEND_SUCCESS);
    }
}
