package com.goorm.profileboxcomm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.goorm.profileboxcomm.enumeration.MemberType;
import com.goorm.profileboxcomm.dto.member.MemberDTO;
import com.goorm.profileboxcomm.utils.Utils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "member", uniqueConstraints = {@UniqueConstraint(columnNames = "member_email")})
public class Member {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_type")
    @NotNull
    private MemberType memberType;

    @Column(name = "member_email")
    @NotNull
    @NotBlank
    private String memberEmail;

    @Column(name = "member_password")
    @NotNull
    @NotBlank
    private String memberPassword;

    @Column(name = "member_name")
    @NotNull
    @NotBlank
    private String memberName;

    @Column(name = "member_gender")
    @NotNull
    @NotBlank
    private String memberGender;

    @Column(name = "member_tel_no")
    @NotNull
    @NotBlank
    private String memberTelNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "member_birth_dt")
    @NotNull
    private Date memberBirthDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    // v1
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Profile profile;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
        modifyDt = now;
    }

    @PreUpdate
    protected void onModify() {
        modifyDt = LocalDateTime.now();
    }

    // method
    public static MemberDTO toDTO(Member entity){
        return MemberDTO.builder()
                .id(entity.getMemberId())
                .userType(entity.getMemberType().toString())
                .email(entity.getMemberEmail())
                .password(entity.getMemberPassword())
                .username(entity.getMemberName())
                .gender(entity.getMemberGender())
                .telNo(entity.getMemberTelNo())
                .birthDate(Utils.dateToString(entity.getMemberBirthDt()))
//                .profileId(entity.getProfile().getProfileId())
                .build();
    }
}
