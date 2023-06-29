package com.goorm.profileboxcomm.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.goorm.profileboxcomm.exception.ApiExceptionEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ApiResult<T>{
    private String status;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApiExceptionEntity exception;

    @Builder
    public ApiResult(String status, String message, T data, ApiExceptionEntity exception) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.exception = exception;
    }

    public static ApiResult getResult(ApiResultType resultType, String func, Object data){
        String message = func;
        message = resultType.equals(ApiResultType.SUCCESS)
                        ? func + " 성공했습니다."
                        : func + " 실패했습니다.";

        return ApiResult.builder()
                .status(resultType.toString())
                .message(message)
                .data(data)
                .build();
    }
}