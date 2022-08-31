package com.github.wangran99.welink.api.client.openapi.exception;
import lombok.Data;

@Data
public class OpenApiException extends RuntimeException{
    private int  code;
    private String msg;

    public OpenApiException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

}
