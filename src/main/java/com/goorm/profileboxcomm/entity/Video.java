package com.goorm.profileboxcomm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.goorm.profileboxcomm.dto.video.request.CreateVideoRequestDto;
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
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    @Column(name = "file_name")
    @NotNull
    @NotBlank
    private String fileName;

    @Column(name = "file_real_name")
    @NotNull
    @NotBlank
    private String fileRealName;

    @Column(name = "file_path")
    @NotNull
    @NotBlank
    private String filePath;

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
    public static Video createVideo(CreateVideoRequestDto videoDto, Profile profile) {
        Video video = new Video();
        video.setFileName(videoDto.getFileName());
        video.setFilePath(videoDto.getFilePath());
        video.setFileRealName(videoDto.getFileRealName());
        video.setProfile(profile);
        return video;
    }
}