package com.goorm.profileboxcomm.dto.link.response;

import com.goorm.profileboxcomm.entity.LinkEntity;
import lombok.Data;

@Data
public class SelectLinkResponseDto {
    private String linkId;
    private String link;
    private String linkName;
    private String createDt;

    public SelectLinkResponseDto(LinkEntity linkEntity) {
        this.linkId = linkEntity.getLinkId().toString();
        this.link = linkEntity.getLink();
        this.linkName = linkEntity.getLinkName();
        this.createDt = linkEntity.getCreateDt().toString();
    }
}
