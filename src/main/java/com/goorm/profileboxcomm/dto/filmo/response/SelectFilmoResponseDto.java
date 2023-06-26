package com.goorm.profileboxcomm.dto.filmo.response;

import com.goorm.profileboxcomm.entity.FilmoEntity;
import com.goorm.profileboxcomm.entity.enumeration.FilmoType;
import lombok.Data;

@Data
public class SelectFilmoResponseDto {
    private String filmoId;
    private FilmoType filmoType;
    private String filmoName;
    private String filmoYear;
    private String filmoDirector;
    private String createDt;
//    private SelectImageResponseDto filmoImage;

    public SelectFilmoResponseDto(FilmoEntity filmoEntity) {
        this.filmoId = filmoEntity.getFilmoId().toString();
        this.filmoType = filmoEntity.getFilmoType();
        this.filmoName = filmoEntity.getFilmoName();
        this.filmoYear = filmoEntity.getFilmoYear();
        this.filmoDirector = filmoEntity.getFilmoDirector();
        this.createDt = filmoEntity.getCreateDt().toString();
//        this.filmoImage = (filmo.getFilmoImage() != null) ? new SelectImageResponseDto(filmo.getFilmoImage()) : new SelectImageResponseDto();
    }
}