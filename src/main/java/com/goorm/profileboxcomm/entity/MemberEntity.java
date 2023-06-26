package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.entity.enumeration.MemberType;
import com.goorm.profileboxcomm.tmp.dto.MemberDTO;
import jakarta.persistence.*;
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
public class MemberEntity {
    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_gender")
    private String memberGender;

    @Column(name = "member_tel_no")
    private String memberTelNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "member_birth_dt")
    private Date memberBirthDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    // One-to-Many relationship with Image entity
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "member_id")
//    private List<Profile> profiles;

    // v1
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private ProfileEntity profile;

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

    public static MemberDTO toDTO(MemberEntity entity){
        return MemberDTO.builder()
                .id(entity.getMemberId())
                .userType(entity.getMemberType().toString())
                .email(entity.getMemberEmail())
                .password(entity.getMemberPassword())
                .username(entity.getMemberName())
                .gender(entity.getMemberGender())
                .telNo(entity.getMemberTelNo())
                .birthDate(entity.getMemberBirthDt().toString())
                .profileId(entity.getProfile().getProfileId())
                .build();
    }
}
