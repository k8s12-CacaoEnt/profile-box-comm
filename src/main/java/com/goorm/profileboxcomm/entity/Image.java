package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "image")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgageId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_real_name")
    private String fileRealName;

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
    public static Image createImage(CreateImageRequestDto imageDto, Profile profile) {
        Image image = new Image();
        image.setFileName(imageDto.getFileName());
        image.setFilePath(imageDto.getFilePath());
        image.setFileRealName(imageDto.getFileRealName());
        image.setProfile(profile);
        return image;
    }
   }

