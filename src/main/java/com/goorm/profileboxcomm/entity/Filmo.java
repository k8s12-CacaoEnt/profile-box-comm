package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.entity.enumeration.FilmoType;
import com.goorm.profileboxcomm.dto.filmo.request.CreateFilmoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "filmo")
@Getter @Setter
public class Filmo {
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

    @Column(name = "create_dt")
    private LocalDateTime createDt;

    // One-to-One relationship with Image entity
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "image_id")
//    private Image filmoImage;

    @PrePersist
    public void prePersist() {
        createDt = LocalDateTime.now();
    }

    // Many-to-One relationship with Profile entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public static Filmo createFilmo(CreateFilmoRequestDto filmoDto, Profile profile) {
        Filmo filmo = new Filmo();
        filmo.setFilmoType(filmoDto.getFilmoType());
        filmo.setFilmoName(filmoDto.getFilmoName());
        filmo.setFilmoYear(filmoDto.getFilmoYear());
        filmo.setFilmoDirector(filmoDto.getFilmoDirector());
        filmo.setProfile(profile);
        return filmo;
    }

    // Getters and Setters

    // Constructor
}
