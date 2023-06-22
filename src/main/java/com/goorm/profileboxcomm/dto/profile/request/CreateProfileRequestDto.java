package com.goorm.profileboxcomm.dto.profile.request;

import com.goorm.profileboxcomm.dto.filmo.request.CreateFilmoRequestDto;
import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
import com.goorm.profileboxcomm.dto.link.request.CreateLinkRequestDto;
import com.goorm.profileboxcomm.dto.video.request.CreateVideoRequestDto;
import lombok.Data;

import java.util.List;

@Data
public class CreateProfileRequestDto {
    private String content;
    private String title;
    private String defaultImageName;
    private String memberId;

    private List<CreateImageRequestDto> images;
    private List<CreateVideoRequestDto> videos;
    private List<CreateFilmoRequestDto> filmos;
    private List<CreateLinkRequestDto> links;

    public CreateProfileRequestDto(){

    }

//    public CreateProfileRequestDto(String content, String defaultImageName, String createDt, String memberid, List<FilmoDto> filmos, List<LinkDto> links, List<MultipartFile> imageFiles, List<MultipartFile> videoFiles, MultipartFile filmoFile, List<ImageDto> images, List<VideoDto> videos) {
//        this.content = content;
//        this.defaultImageName = defaultImageName;
//        this.createDt = createDt;
//        this.memberid = memberid;
//        this.filmos = filmos;
//        this.links = links;
//        this.imageFiles = imageFiles;
//        this.videoFiles = videoFiles;
//        this.filmoFile = filmoFile;
//        this.images = images;
//        this.videos = videos;
//    }
}
