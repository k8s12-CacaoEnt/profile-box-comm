package com.goorm.profileboxcomm.dto.link.request;

import lombok.Data;

@Data
public class CreateLinkRequestDto {
    private String link;
    private String linkName;

    public CreateLinkRequestDto() {
    }

    public CreateLinkRequestDto(String link, String linkName) {
        this.link = link;
        this.linkName = linkName;
    }
}
