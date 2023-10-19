package com.backend.wantedpreonboardingbackend.employment.domain.attend;

import com.backend.wantedpreonboardingbackend.employment.domain.employment.Employment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employmentId")
    private Employment employmentId;

    @Column(nullable = false)
    private Long userId;

    public static Attend createAttend(Employment employmentId, Long userId) {
        return Attend.builder()
                .employmentId(employmentId)
                .userId(userId)
                .build();
    }
}
