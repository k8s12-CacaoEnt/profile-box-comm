package com.goorm.profileboxcomm.tmp.entity;

import com.goorm.profileboxcomm.tmp.dto.NoticeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
//@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Notice")
public class NoticeEntity {

    @Id
    @Column(name="notice_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long noticeId;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    @Column(name = "filmo_type")
    String filmo_type;

    @Column(name = "filmo_name")
    String filmo_name;

    @Column(name = "filmo_fole")
    String filmo_role;

    @Column(name = "filming_period")
    String filming_period;

    @Column(name = "create_dt")
    Timestamp create_dt;

    @Column(name = "modify_dt")
    Timestamp modify_dt;

    @Column(name = "member_id")
    Long member_id;

    public static NoticeDTO toDTO(NoticeEntity entity){
        return NoticeDTO.builder()
                .noticeId(entity.getNoticeId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .filmo_type(entity.getFilmo_type())
                .filmo_name(entity.getFilmo_name())
                .filmo_role(entity.getFilmo_role())
                .filming_start_period(entity.getFilming_period())
                .filming_end_period(entity.getFilming_period())
                .create_dt(entity.getCreate_dt())
                .modify_dt(entity.getModify_dt())
                .member_id(entity.getMember_id())
                .build();
    }

}
