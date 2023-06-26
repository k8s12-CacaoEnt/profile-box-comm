package com.goorm.profileboxcomm.tmp.dto;

import com.goorm.profileboxcomm.tmp.entity.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    private Long profileId;
    private String content;
    private String title;
    private Long default_image_id;
    private Timestamp create_date;
    private Timestamp modify_date;
    private Long member_id;

    public static ProfileEntity toEntity(ProfileDTO dto){
        return ProfileEntity.builder()
                .profileId(dto.getProfileId())
                .content(dto.getContent())
                .title(dto.getTitle())
                .default_image_id(dto.getDefault_image_id())
                .create_date(dto.getCreate_date())
                .modify_date(dto.getModify_date())
                .member_id(dto.getMember_id())
                .build();
    }
}
