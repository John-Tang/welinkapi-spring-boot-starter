package com.github.wangran99.welink.api.client.openapi.exception;
import lombok.Data;

@Data
public class AuthFailOrExpiredException extends RuntimeException{

    private int  code;
    private String msg;
    private String authUrl;

    public AuthFailOrExpiredException() {
        super("authorization failed or expired");
        this.msg = "authorization failed or expired";
        this.code = 2; //无认证token或者token过期，详情见ResultCode.java类
    }
}
