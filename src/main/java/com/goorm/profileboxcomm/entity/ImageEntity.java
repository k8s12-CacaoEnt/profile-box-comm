package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgageId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_real_name")
    private String fileRealName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    // Many-to-One relationship with Profile entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
    }

    // Constructor
    public static ImageEntity createImage(CreateImageRequestDto imageDto, ProfileEntity profile) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setFileName(imageDto.getFileName());
        imageEntity.setFilePath(imageDto.getFilePath());
        imageEntity.setFileRealName(imageDto.getFileRealName());
        imageEntity.setProfile(profile);
        return imageEntity;
    }
   }

