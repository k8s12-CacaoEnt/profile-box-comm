package com.goorm.profileboxcomm.utils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.transfer.TransferManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor    // final 멤버변수가 있으면 생성자 항목에 포함시킴
@Component
@Service
public class S3Uploader {

    private final AmazonS3 amazonS3Client;
    private final TransferManager transferManager;

//    private final AmazonS3 amazonS3Client;
//    private final TransferManager transferManager;
//
//    public S3Uploader(AmazonS3 amazonS3Client, TransferManager transferManager) {
//        this.amazonS3Client = amazonS3Client;
//        this.transferManager = transferManager;
//    }

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public String uploadMultipartFile(MultipartFile multipartFile, String fileName) throws IOException {
//        String bucketName = "your-bucket-name"; // S3 버킷 이름
//        String folderName = "your-folder-name"; // S3 버킷 내 폴더 이름
//        String fileName = generateUniqueFileName(origName);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(multipartFile.getContentType());
        metadata.setContentLength(multipartFile.getSize());

//        amazonS3Client.putObject(bucketName, folderName + "/" + fileName, multipartFile.getInputStream(), metadata);
        amazonS3Client.putObject(bucketName, fileName, multipartFile.getInputStream(), metadata);

        return generateS3FileUrl(bucketName, fileName);
    }

    public String generateUniqueFileName(String originalFilename) {
        String fileExtension = getFileExtension(originalFilename);
        String uniqueFileName = UUID.randomUUID().toString();

        return uniqueFileName + fileExtension;
    }

    public String getFileExtension(String filename) {
        if (filename.lastIndexOf(".") != -1 && filename.lastIndexOf(".") != 0) {
            return filename.substring(filename.lastIndexOf("."));
        } else {
            return "";
        }
    }

    private String generateS3FileUrl(String bucketName, String fileName) {
        String s3BaseUrl = "https://s3.amazonaws.com";
        return s3BaseUrl + "/" + bucketName + "/"  + fileName;
    }


    // MultipartFile을 전달받아 File로 전환한 후 S3에 업로드
//    public String upload(MultipartFile multipartFile, String dirName) throws IOException {
//        File uploadFile = convert(multipartFile)
//                .orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File 전환 실패"));
//        return upload(uploadFile, dirName);
//    }

//    private String upload(File uploadFile, String fileName) {
//
//
////        String fileName = dirName + "/" + uploadFile.getName();
////        String uploadImageUrl = putS3(uploadFile, fileName);
////
////        removeNewFile(uploadFile);  // 로컬에 생성된 File 삭제 (MultipartFile -> File 전환 하며 로컬에 파일 생성됨)
////
////        return uploadImageUrl;      // 업로드된 파일의 S3 URL 주소 반환
//    }

//    private String putS3(File uploadFile, String fileName) {
//        amazonS3Client.putObject(
//                new PutObjectRequest(bucket, fileName, uploadFile)
//                        .withCannedAcl(CannedAccessControlList.PublicRead)	// PublicRead 권한으로 업로드 됨
//        );
//        return amazonS3Client.getUrl(bucket, fileName).toString();
//    }
//
//    private void removeNewFile(File targetFile) {
//        if(targetFile.delete()) {
//            log.info("파일이 삭제되었습니다.");
//        }else {
//            log.info("파일이 삭제되지 못했습니다.");
//        }
//    }
//
//    private Optional<File> convert(MultipartFile file) throws  IOException {
//        File convertFile = new File(file.getOriginalFilename());
//        if(convertFile.createNewFile()) {
//            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
//                fos.write(file.getBytes());
//            }
//            return Optional.of(convertFile);
//        }
//        return Optional.empty();
//    }

}