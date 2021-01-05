package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

@Data
public class AuthFailOrExpiredException extends RuntimeException{

    private int  code;
    private String msg;
    private String authUrl;

    public AuthFailOrExpiredException(IException iException) {
        super();
        this.msg = iException.getDesc();
        this.code = iException.getCode();
    }
}
