package com.goorm.profileboxcomm.dto.member;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.enumeration.MemberType;
import com.goorm.profileboxcomm.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String birthDate; //1995-12-09
    private Long profileId;

    public static Member toEntity(final MemberDTO dto) {
        return Member.builder()
                .memberId(dto.getId())
                .memberType(MemberType.valueOf(dto.getUserType()))
                .memberEmail(dto.getEmail())
                .memberPassword(dto.getPassword())
                .memberName(dto.getUsername())
                .memberGender(dto.getGender())
                .memberTelNo(dto.getTelNo())
                .memberBirthDt(Utils.stringToDate(dto.getBirthDate()))
                .build();
    }
}
