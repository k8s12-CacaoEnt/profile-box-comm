package com.goorm.profileboxcomm.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001", "런타임 에러입니다."),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0003"),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "E0004", "멤버가 존재하지 않습니다."),
    PROFILE_NOT_FOUND(HttpStatus.NOT_FOUND, "E0005", "프로필이 존재하지 않습니다."),
    LOGIN_FAILED(HttpStatus.NOT_FOUND, "E0006", "멤버가 존재하지 않거나 패스워드가 일치하지 않습니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "E0007", "유효하지 않는 요청입니다."),
    INVALID_DATE_FORMAT(HttpStatus.BAD_REQUEST, "E0008", "데이트 포맷 파싱 에러입니다."),
    NOTICE_NOT_FOUND(HttpStatus.NOT_FOUND, "E0009", "공지사항이 존재하지 않습니다."),
    SECURITY(HttpStatus.UNAUTHORIZED, "CE0001", "로그인이 필요합니다.");

    private final HttpStatus status;
    private final String code;
    private String message;

    ExceptionEnum(HttpStatus status, String code){
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
