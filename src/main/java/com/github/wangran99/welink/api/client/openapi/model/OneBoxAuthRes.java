package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/19 14:24
 * @description：OneBox鉴权返回的数据
 */
@Data
public class OneBoxAuthRes {
    String token;
    String refreshToken;
    int timeout;
    long userId;
    long cloudUserId;
    String loginName;
    int uploadQos;
    int downloadQos;
    int enterpriseId;
    int accountId;
    int domain;
    int cacheTime;
    long espaceCloudUserId;
}
