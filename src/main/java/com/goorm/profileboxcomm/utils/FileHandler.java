package com.goorm.profileboxcomm.utils;

import com.goorm.profileboxcomm.dto.image.request.CreateImageRequestDto;
import com.goorm.profileboxcomm.dto.video.request.CreateVideoRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Component
public class FileHandler {

    @Value("${custom.storage.filePath}")
    private String FILE_UPLOAD_PATH;
    @Value("${custom.storage.imagePath}")
    private String IMAGE_UPLOAD_PATH;
    @Value("${custom.storage.videoPath}")
    private String VIDEO_UPLOAD_PATH;

    public CreateImageRequestDto imageWrite(MultipartFile file){
        String origName = file.getOriginalFilename();
        // 파일 이름으로 쓸 uuid 생성
        String uuid = UUID.randomUUID().toString();
        // 확장자 추출(ex : .png)
        String extension = origName.substring(origName.lastIndexOf("."));
        // uuid와 확장자 결합
        String savedName = uuid + extension;
        // 파일을 불러올 때 사용할 파일 경로
        String savedDt = new Date().toString();
        String savedPath = FILE_UPLOAD_PATH + IMAGE_UPLOAD_PATH + savedName;

        if (!new File(FILE_UPLOAD_PATH + IMAGE_UPLOAD_PATH).exists()) {
            new File(FILE_UPLOAD_PATH + IMAGE_UPLOAD_PATH).mkdirs();
        }

        try {
            file.transferTo(new File(savedPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new CreateImageRequestDto(savedName, FILE_UPLOAD_PATH + IMAGE_UPLOAD_PATH, origName);
    }

    public CreateVideoRequestDto videoWrite(MultipartFile file){
        String origName = file.getOriginalFilename();
        // 파일 이름으로 쓸 uuid 생성
        String uuid = UUID.randomUUID().toString();
        // 확장자 추출(ex : .png)
        String extension = origName.substring(origName.lastIndexOf("."));
        // uuid와 확장자 결합
        String savedName = uuid + extension;
        // 파일을 불러올 때 사용할 파일 경로
        String savedDt = new Date().toString();
        String savedPath = FILE_UPLOAD_PATH + VIDEO_UPLOAD_PATH + savedName;
        try {
            file.transferTo(new File(savedPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new CreateVideoRequestDto(savedName, FILE_UPLOAD_PATH + VIDEO_UPLOAD_PATH, origName);
    }


    public void fileWrite(MultipartFile file){

    }
}
