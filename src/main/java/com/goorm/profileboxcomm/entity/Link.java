package com.goorm.profileboxcomm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.goorm.profileboxcomm.dto.link.request.CreateLinkRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "link")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;

    @Column(name = "link")
    @NotNull
    @NotBlank
    private String link;

    @Column(name = "link_name")
    @NotNull
    @NotBlank
    private String linkName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    // Many-to-One relationship with Profile entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    @JsonBackReference
//    @JsonIgnore
    private Profile profile;

    // Getters and Setters
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
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