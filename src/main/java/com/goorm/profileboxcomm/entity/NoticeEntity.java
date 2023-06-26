package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.entity.enumeration.FilmoType;
import com.goorm.profileboxcomm.tmp.dto.NoticeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="notice")
public class NoticeEntity {
    @Id
    @Column(name="notice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @Column(name = "notice_title")
    private String noticeTitle;

    @Column(name = "notice_content")
    private String noticeContent;

    @Column(name = "filmo_type")
    private FilmoType filmoType;

    @Column(name = "filmo_name")
    private String filmoName;

    @Column(name = "filmo_role")
    private String filmoRole;

    @Temporal(TemporalType.DATE)
    @Column(name = "apply_deadline_dt")
    private Date applyDeadlineDt;

    @Temporal(TemporalType.DATE)
    @Column(name = "filming_start_period")
    private Date filmingStartPeriod;

    @Temporal(TemporalType.DATE)
    @Column(name = "filming_end_period")
    private Date filmingEndPeriod;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
    }

    @PreUpdate
    protected void onModify() {
        modifyDt = LocalDateTime.now();
    }

    public static NoticeDTO toDTO(NoticeEntity entity){
        return NoticeDTO.builder()
                .noticeId(entity.getNoticeId())
                .title(entity.getNoticeTitle())
                .content(entity.getNoticeContent())
                .filmo_type(entity.getFilmoType().toString())
                .filmo_name(entity.getFilmoName())
                .filmo_role(entity.getFilmoRole())
                .apply_deadline_dt(entity.getApplyDeadlineDt().toString())
                .filming_start_period(entity.getFilmingStartPeriod().toString())
                .filming_end_period(entity.getFilmingEndPeriod().toString())
                .create_dt(Timestamp.valueOf(entity.getCreateDt()))
                .modify_dt(Timestamp.valueOf(entity.getModifyDt()))
                .member_id(entity.getMember().getMemberId())
                .build();
    }

}
