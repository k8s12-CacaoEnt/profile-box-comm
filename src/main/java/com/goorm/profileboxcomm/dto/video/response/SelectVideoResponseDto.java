package com.goorm.profileboxcomm.dto.video.response;

import com.goorm.profileboxcomm.entity.Video;
import lombok.Data;

@Data
public class SelectVideoResponseDto {
    private String videoId;
    private String fileName;
    private String fileRealName;
    private String filePath;
    private String createDt;

    public SelectVideoResponseDto(Video video) {
        this.videoId = video.getVideoId().toString();
        this.fileName = video.getFileName();
        this.fileRealName = video.getFileRealName();
        this.filePath = video.getFilePath();
        this.createDt = video.getCreateDt().toString();
    }
}

