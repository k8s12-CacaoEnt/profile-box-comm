package com.goorm.profileboxcomm.tmp.entity;

import com.goorm.profileboxcomm.tmp.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "member_email")})
public class MemberEntity {
    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "member_type")
    private String userType;

    @Column(nullable = false, name = "member_email")
    private String email;

    @Column(nullable = false, name = "member_password")
    private String password;

    @Column(nullable = false, name = "member_name")
    private String username;

    @Column(nullable = false, name = "member_gender")
    private String gender;

    @Column(nullable = false, name = "member_tel_no")
    private String telNo;

    @Column(nullable = false, name = "member_birth_dt")
    private String birthDate;

    @Column(name = "profile_id")
    private Long profileId;



    public static MemberDTO toDTO(MemberEntity entity){
        return MemberDTO.builder()
                .id(entity.getId())
                .userType(entity.getUserType())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .username(entity.getUsername())
                .gender(entity.getGender())
                .telNo(entity.getTelNo())
                .birthDate(entity.getBirthDate())
                .profileId(entity.getProfileId())
                .build();
    }
}
