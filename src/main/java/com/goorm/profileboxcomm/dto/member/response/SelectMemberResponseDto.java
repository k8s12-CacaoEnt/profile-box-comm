package com.goorm.profileboxcomm.dto.member.response;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.entity.enumeration.MemberType;
import lombok.Data;

@Data
public class SelectMemberResponseDto {
    private String memberId;
    private MemberType memberType;
    private String memberEmail;
    private String memberName;
    private String gender;
    private String telNo;
    private String birthDt;
//    private SelectProfileResponseDto profile;

    public SelectMemberResponseDto(Member member) {
        this.memberId = member.getMemberId().toString();
        this.memberType = member.getMemberType();
        this.memberEmail = member.getMemberEmail();
        this.memberName = member.getMemberName();
        this.gender = member.getMemberGender();
        this.telNo = member.getMemberTelNo();
        this.birthDt = member.getMemberBirthDt();
//        this.profile = convertProfilesToDto(member.getProfiles());
    }

//    private List<SelectProfileResponseDto> convertProfilesToDto(List<Profile> profiles) {
//        return profiles.stream()
//                .map(SelectProfileResponseDto::new)
//                .collect(Collectors.toList());
//    }
}