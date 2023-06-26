package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.entity.enumeration.FilmoType;
import com.goorm.profileboxcomm.dto.filmo.request.CreateFilmoRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "filmo")
public class FilmoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmoId;

    @Enumerated(EnumType.STRING)
    private FilmoType filmoType;

    @Column(name = "filmo_name")
    private String filmoName;

    @Column(name = "filmo_year")
    private String filmoYear;

    @Column(name = "filmo_director")
    private String filmoDirector;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    // One-to-One relationship with Image entity
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "image_id")
//    private Image filmoImage;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDt = now;
    }

    @PreUpdate
    protected void onModify() {
        modifyDt = LocalDateTime.now();
    }

    // Many-to-One relationship with Profile entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    public static FilmoEntity createFilmo(CreateFilmoRequestDto filmoDto, ProfileEntity profile) {
        FilmoEntity filmoEntity = new FilmoEntity();
        filmoEntity.setFilmoType(filmoDto.getFilmoType());
        filmoEntity.setFilmoName(filmoDto.getFilmoName());
        filmoEntity.setFilmoYear(filmoDto.getFilmoYear());
        filmoEntity.setFilmoDirector(filmoDto.getFilmoDirector());
        filmoEntity.setProfile(profile);
        return filmoEntity;
    }

    // Getters and Setters

    // Constructor
}
