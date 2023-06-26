package com.goorm.profileboxcomm.tmp.entity;

import com.goorm.profileboxcomm.tmp.dto.ProfileDTO;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ProfileEntity {
    @Id
    @Column(name="profile_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profileId;

    @Column(name="content")
    private String content;

    @Column(name="title")
    private String title;

    @Column(name="default_image_id")
    private Long default_image_id;

    @Column(name = "create_dt")
    private Timestamp create_date;

    @Column(name = "modify_dt")
    private Timestamp modify_date;

    @Column(name="member_id")
    private Long member_id;

    public static ProfileDTO toDTO(ProfileEntity entity){
        return ProfileDTO.builder()
                .profileId(entity.getProfileId())
                .content(entity.getContent())
                .title(entity.getTitle())
                .default_image_id(entity.getDefault_image_id())
                .create_date(entity.getCreate_date())
                .modify_date(entity.getModify_date())
                .member_id(entity.getMember_id())
                .build();

    }

}
