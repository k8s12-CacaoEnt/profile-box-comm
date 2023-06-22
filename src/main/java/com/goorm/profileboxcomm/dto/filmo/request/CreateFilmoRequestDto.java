package com.goorm.profileboxcomm.dto.filmo.request;

import com.goorm.profileboxcomm.entity.enumeration.FilmoType;
import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
import lombok.Data;

@Data
public class CreateFilmoRequestDto {
    private FilmoType filmoType;
    private String filmoName;
    private String filmoYear;
    private String filmoDirector;
//    private CreateImageRequestDto filmoImage;

    public CreateFilmoRequestDto() {
    }

    public CreateFilmoRequestDto(FilmoType filmoType, String filmoName, String filmoYear, String filmoDirector, CreateImageRequestDto filmoImage) {
        this.filmoType = filmoType;
        this.filmoName = filmoName;
        this.filmoYear = filmoYear;
        this.filmoDirector = filmoDirector;
//        this.filmoImage = filmoImage;
    }
}
