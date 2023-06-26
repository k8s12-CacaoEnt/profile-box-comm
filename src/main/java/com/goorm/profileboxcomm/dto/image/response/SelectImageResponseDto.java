package com.goorm.profileboxcomm.dto.image.response;

import com.goorm.profileboxcomm.entity.ImageEntity;
import lombok.Data;

@Data
public class SelectImageResponseDto {
    private String imageId;
    private String fileName;
    private String filePath;
    private String fileRealName;
    private String createDt;
    public SelectImageResponseDto() {
    }

    public SelectImageResponseDto(ImageEntity imageEntity) {
        this.imageId = imageEntity.getImgageId().toString();
        this.fileName = imageEntity.getFileName();
        this.filePath = imageEntity.getFilePath();
        this.fileRealName = imageEntity.getFileRealName();
        this.createDt = imageEntity.getCreateDt().toString();
    }
}
