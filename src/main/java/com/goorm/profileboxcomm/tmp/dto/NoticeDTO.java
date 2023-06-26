package com.goorm.profileboxcomm.tmp.dto;

import com.goorm.profileboxcomm.entity.NoticeEntity;
import com.goorm.profileboxcomm.entity.enumeration.FilmoType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {

    Long noticeId;
    String title;
    String content;
    String filmo_type;
    String filmo_name;
    String filmo_role;
    String apply_deadline_dt;
    String filming_start_period;
    String filming_end_period;
    Timestamp create_dt;
    Timestamp modify_dt;
    Long member_id;

    public static NoticeEntity toEntity(final NoticeDTO dto) throws ParseException {
        return NoticeEntity.builder()
                .noticeId(dto.getNoticeId())
                .noticeTitle(dto.getTitle())
                .noticeContent(dto.getContent())
                .filmoType(FilmoType.valueOf(dto.getFilmo_type()))
                .filmoName(dto.getFilmo_name())
                .filmoRole(dto.getFilmo_role())
                .applyDeadlineDt(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getApply_deadline_dt()))
                .filmingStartPeriod(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getFilming_start_period()))
                .filmingEndPeriod(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getFilming_end_period()))
                .build();
        // MemberId 는 JPA에서 memberId 로 멤버 조회하여 멤버 Entity를 넣어줘야함
    }
}
