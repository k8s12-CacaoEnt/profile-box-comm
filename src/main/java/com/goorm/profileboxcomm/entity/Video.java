package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.video.request.CreateVideoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "video")
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_real_name")
    private String fileRealName;

    @Column(name = "file_path")
    private String filePath;

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
    public static Video createVideo(CreateVideoRequestDto videoDto, Profile profile) {
        Video video = new Video();
        video.setFileName(videoDto.getFileName());
        video.setFilePath(videoDto.getFilePath());
        video.setFileRealName(videoDto.getFileRealName());
        video.setProfile(profile);
        return video;
    }
}