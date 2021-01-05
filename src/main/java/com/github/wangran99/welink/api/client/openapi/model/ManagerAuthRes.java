package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

@Data
public class ManagerAuthRes {
    String token_type;
    long expires_in;
    String access_token;
}
