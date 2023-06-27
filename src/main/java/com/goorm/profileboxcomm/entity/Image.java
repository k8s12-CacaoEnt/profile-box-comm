package com.goorm.profileboxcomm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
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
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgageId;

    @Column(name = "file_name")
    @NotNull
    @NotBlank
    private String fileName;

    @Column(name = "file_path")
    @NotNull
    @NotBlank
    private String filePath;

    @Column(name = "file_real_name")
    @NotNull
    @NotBlank
    private String fileRealName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    // Many-to-One relationship with Profile entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    @JsonBackReference
//    @JsonIgnore
    private Profile profile;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
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

