package com.goorm.profileboxcomm.entity;

import com.goorm.profileboxcomm.entity.enumeration.MemberType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "member")
@Getter
@Setter
//@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_gender")
    private String memberGender;

    @Column(name = "member_tel_no")
    private String memberTelNo;

    @Temporal(TemporalType.TIMESTAMP)
    private String memberBirthDt;

    // One-to-Many relationship with Image entity
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "member_id")
//    private List<Profile> profiles;

    // v1
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private Profile profile;
}
