package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Data;

@Data
public class JsAuthDomain {
    String appId; // 应用的client_id
    Long timestamp; // 与生成签名一致的时间戳，精确到秒十位
    String noncestr; // 服务端使用的随机串，要处理成小写字符
    String signature; // 签名信息，要处理成小写字符
    String jstickets;
    String url;
}