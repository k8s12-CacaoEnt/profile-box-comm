package com.goorm.profileboxcomm.dto;

import com.goorm.profileboxcomm.entity.Member;
import lombok.Data;

@Data
public class MemberDto {
    private String memberId;
    private String memberName;
    private String memberType;
    private String gender;
    private String telNo;
    private String birthDt;

    public MemberDto(Member member) {
        this.memberId = member.getMemberId().toString();
        this.memberName = member.getMemberName();
        this.memberType = member.getMemberType().toString();
        this.gender = member.getMemberGender();
        this.telNo = member.getMemberTelNo();
        this.birthDt = member.getMemberBirthDt();
    }
}
