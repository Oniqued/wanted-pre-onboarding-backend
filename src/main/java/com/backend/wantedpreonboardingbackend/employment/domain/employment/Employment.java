package com.backend.wantedpreonboardingbackend.employment.domain.employment;

import com.backend.wantedpreonboardingbackend.employment.domain.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company companyId;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String skill;

    public static Employment createPost(Company companyId, String position, Integer reward, String content, String skill) {
        return Employment.builder()
                .companyId(companyId)
                .position(position)
                .reward(reward)
                .content(content)
                .skill(skill)
                .build();
    }
}
