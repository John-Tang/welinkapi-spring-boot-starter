package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 14:22
 * @description：
 */
@Data
public class AuthReq {
    private String client_id;
    private String client_secret;
    private String tenant_id;
    private String token;//不同租户获得token
}
