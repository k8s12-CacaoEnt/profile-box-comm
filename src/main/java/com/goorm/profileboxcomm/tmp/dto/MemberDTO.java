package com.goorm.profileboxcomm.tmp.dto;

import com.goorm.profileboxcomm.entity.MemberEntity;
import com.goorm.profileboxcomm.entity.enumeration.MemberType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String token;
    private Long id;
    private String userType;
    private String email;
    private String password;
    private String username;
    private String gender;
    private String telNo;
    private String birthDate;
    private Long profileId;

    public static MemberEntity toEntity(final MemberDTO dto) throws ParseException {
        return MemberEntity.builder()
                .memberId(dto.getId())
                .memberType(MemberType.valueOf(dto.getUserType()))
                .memberEmail(dto.getEmail())
                .memberPassword(dto.getPassword())
                .memberName(dto.getUsername())
                .memberGender(dto.getGender())
                .memberTelNo(dto.getTelNo())
                .memberBirthDt(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getBirthDate()))
                .build();
    }
}
