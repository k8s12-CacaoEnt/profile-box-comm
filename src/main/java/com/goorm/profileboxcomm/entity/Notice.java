package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.entity.enumeration.FilmoType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "notice")
@Getter
@Setter
public class Notice {
    @Id
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

    @Column(name = "filemo_role")
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
    private Member member;

}
