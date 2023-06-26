package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.video.request.CreateVideoRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "video")
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_real_name")
    private String fileRealName;

    @Column(name = "file_path")
    private String filePath;

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
    public static VideoEntity createVideo(CreateVideoRequestDto videoDto, ProfileEntity profile) {
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setFileName(videoDto.getFileName());
        videoEntity.setFilePath(videoDto.getFilePath());
        videoEntity.setFileRealName(videoDto.getFileRealName());
        videoEntity.setProfile(profile);
        return videoEntity;
    }
}