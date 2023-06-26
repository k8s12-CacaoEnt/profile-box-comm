package com.goorm.profileboxcomm.dto.video.response;

import com.goorm.profileboxcomm.entity.VideoEntity;
import lombok.Data;

@Data
public class SelectVideoResponseDto {
    private String videoId;
    private String fileName;
    private String fileRealName;
    private String filePath;
    private String createDt;

    public SelectVideoResponseDto(VideoEntity videoEntity) {
        this.videoId = videoEntity.getVideoId().toString();
        this.fileName = videoEntity.getFileName();
        this.fileRealName = videoEntity.getFileRealName();
        this.filePath = videoEntity.getFilePath();
        this.createDt = videoEntity.getCreateDt().toString();
    }
}

