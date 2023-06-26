package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.profile.request.CreateProfileRequestDto;
import com.goorm.profileboxcomm.tmp.dto.ProfileDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @Column(name="profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "default_image_id")
    private Long defaultImageId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    // One-to-Many relationship with Image entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<ImageEntity> imageEntities;

    // One-to-Many relationship with Video entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<VideoEntity> videoEntities;

    // One-to-Many relationship with Filmo entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<FilmoEntity> filmoEntities;

    // One-to-Many relationship with Link entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<LinkEntity> linkEntities;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
        modifyDt = now;
    }

    @PreUpdate
    protected void onModify() {
        modifyDt = LocalDateTime.now();
    }

    public static ProfileEntity createProfile(CreateProfileRequestDto profileDto, MemberEntity member) {
        ProfileEntity profile = new ProfileEntity();
        profile.setContent(profileDto.getContent());
        profile.setTitle(profileDto.getTitle());
        profile.setMember(member);
        if (profileDto.getImages() != null) {
            profile.setImageEntities(profileDto.getImages().stream()
                    .map(o -> ImageEntity.createImage(o, profile))
                    .collect(toList()));
        }
        if (profileDto.getVideos() != null) {
            profile.setVideoEntities(profileDto.getVideos().stream()
                    .map(o -> VideoEntity.createVideo(o, profile))
                    .collect(toList()));
        }
        if (profileDto.getFilmos() != null) {
            profile.setFilmoEntities(profileDto.getFilmos().stream()
                    .map(o -> FilmoEntity.createFilmo(o, profile))
                    .collect(toList()));
        }
        if (profileDto.getLinks() != null) {
            profile.setLinkEntities(profileDto.getLinks().stream()
                    .map(o -> LinkEntity.createLink(o, profile))
                    .collect(toList()));
        }
        return profile;
    }

    public static ProfileDTO toDTO(com.goorm.profileboxcomm.entity.ProfileEntity entity){
        return ProfileDTO.builder()
                .profileId(entity.getProfileId())
                .content(entity.getContent())
                .title(entity.getTitle())
                .default_image_id(entity.getDefaultImageId())
                .create_date(Timestamp.valueOf(entity.getCreateDt()))
                .modify_date(Timestamp.valueOf(entity.getModifyDt()))
                .member_id(entity.getMember().getMemberId())
                .build();

    }
}

