package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.profile.request.CreateProfileRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "default_image_id")
    private Long defaultImageId;

    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // One-to-Many relationship with Image entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<Image> images;

    // One-to-Many relationship with Video entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<Video> videos;

    // One-to-Many relationship with Filmo entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<Filmo> filmos;

    // One-to-Many relationship with Link entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
    private List<Link> links;

    // Getters and Setters
    @PrePersist
    public void prePersist() {
        createDt = LocalDateTime.now();
    }



    // Constructor
//    public void setImages(List<CreateImageRequestDto> imagesDto) {
//        if (imagesDto != null) {
//            profile.setImages(profileDto.getImages().stream()
//                    .map(o -> Image.createImage(o, this))
//                    .collect(toList()));
//
//        }
////        this.images = images;
//        if (images != null) {
//            for (Image image : images) {
//                image.setProfile(this);
//            }
//        }
//    }
    public static Profile createProfile(CreateProfileRequestDto profileDto, Member member) {
        Profile profile = new Profile();
        profile.setContent(profileDto.getContent());
        profile.setTitle(profileDto.getTitle());
        profile.setMember(member);
        if (profileDto.getImages() != null) {
            profile.setImages(profileDto.getImages().stream()
                    .map(o -> Image.createImage(o, profile))
                    .collect(toList()));
        }
        if (profileDto.getVideos() != null) {
            profile.setVideos(profileDto.getVideos().stream()
                    .map(o -> Video.createVideo(o, profile))
                    .collect(toList()));
        }
        if (profileDto.getFilmos() != null) {
            profile.setFilmos(profileDto.getFilmos().stream()
                    .map(o -> Filmo.createFilmo(o, profile))
                    .collect(toList()));
        }
        if (profileDto.getLinks() != null) {
            profile.setLinks(profileDto.getLinks().stream()
                    .map(o -> Link.createLink(o, profile))
                    .collect(toList()));
        }
        return profile;
    }
}

