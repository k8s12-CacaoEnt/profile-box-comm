package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.link.request.CreateLinkRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "link")
@Getter
@Setter
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;

    @Column(name = "link")
    private String link;

    @Column(name = "link_name")
    private String linkName;

    @Column(name = "create_dt")
    private LocalDateTime createDt;

    // Many-to-One relationship with Profile entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    // Getters and Setters
    @PrePersist
    public void prePersist() {
        createDt = LocalDateTime.now();
    }

    // Constructor
    public static Link createLink(CreateLinkRequestDto linkDto, Profile profile) {
        Link link = new Link();
        link.setLink(linkDto.getLink());
        link.setLinkName(linkDto.getLinkName());
        link.setProfile(profile);
        return link;
    }
}