package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.link.request.CreateLinkRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "link")
public class LinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;

    @Column(name = "link")
    private String link;

    @Column(name = "link_name")
    private String linkName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    // Many-to-One relationship with Profile entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    // Getters and Setters
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
    }

    // Constructor
    public static LinkEntity createLink(CreateLinkRequestDto linkDto, ProfileEntity profile) {
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setLink(linkDto.getLink());
        linkEntity.setLinkName(linkDto.getLinkName());
        linkEntity.setProfile(profile);
        return linkEntity;
    }
}