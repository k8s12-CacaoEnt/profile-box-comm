package com.goorm.profileboxcomm.dto.profile.response;

import com.goorm.profileboxcomm.dto.filmo.response.SelectFilmoResponseDto;
import com.goorm.profileboxcomm.dto.image.response.SelectImageResponseDto;
import com.goorm.profileboxcomm.dto.link.response.SelectLinkResponseDto;
import com.goorm.profileboxcomm.dto.member.response.SelectMemberResponseDto;
import com.goorm.profileboxcomm.dto.video.response.SelectVideoResponseDto;
import com.goorm.profileboxcomm.entity.Profile;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
    public class SelectProfileResponseDto {
        private Long profileId;
        private String title;
        private String content;
        private Long defaultImageId;
        private String createDt;
        private SelectMemberResponseDto memberInfo;
        private List<SelectImageResponseDto> images;
        private List<SelectVideoResponseDto> videos;
        private List<SelectFilmoResponseDto> filmos;
        private List<SelectLinkResponseDto> links;

        public SelectProfileResponseDto(Profile profile) {
            this.profileId = profile.getProfileId();
            this.content = profile.getContent();
            this.title = profile.getTitle();
            this.defaultImageId = profile.getDefaultImageId();
            this.createDt = profile.getCreateDt().toString();
            this.memberInfo = new SelectMemberResponseDto(profile.getMember());
            this.images = profile.getImageEntities().stream()
                    .map(o -> new SelectImageResponseDto(o))
                    .collect(toList());
            this.videos = profile.getVideoEntities().stream()
                    .map(o -> new SelectVideoResponseDto(o))
                    .collect(toList());
            this.filmos = profile.getFilmoEntities().stream()
                    .map(o -> new SelectFilmoResponseDto(o))
                    .collect(toList());
            this.links = profile.getLinkEntities().stream()
                    .map(o -> new SelectLinkResponseDto(o))
                    .collect(toList());
//            this.title = Optional.ofNullable(profile.getTitle()).orElse("");
////            this.defaultImageId = profile.getDefaultImageId().toString();
//            Optional.ofNullable(profile.getDefaultImageId()).map(Object::toString).orElse("");
//            this.profileId = Optional.ofNullable(profile.getProfileId()).map(Object::toString).orElse("");
//            this.content = Optional.ofNullable(profile.getContent()).orElse("");
//            this.defaultImageId = Optional.ofNullable(profile.getDefaultImageId()).map(Object::toString).orElse("");
//            this.createDt = Optional.ofNullable(profile.getCreateDt()).map(Object::toString).orElse("");
//            this.memberInfo = Optional.ofNullable(profile.getMember()).map(MemberDto::new).orElse(null);
//            this.images = Optional.ofNullable(profile.getImages()).orElse(Collections.emptyList()).stream()
//                    .map(SelectImageResponseDto::new)
//                    .collect(Collectors.toList());
//            this.videos = Optional.ofNullable(profile.getVideos()).orElse(Collections.emptyList()).stream()
//                    .map(SelectVideoResponseDto::new)
//                    .collect(Collectors.toList());
//            this.filmos = Optional.ofNullable(profile.getFilmos()).orElse(Collections.emptyList()).stream()
//                    .map(SelectFilmoResponseDto::new)
//                    .collect(Collectors.toList());
//            this.links = Optional.ofNullable(profile.getLinks()).orElse(Collections.emptyList()).stream()
//                    .map(SelectLinkResponseDto::new)
//                    .collect(Collectors.toList());
        }
    }