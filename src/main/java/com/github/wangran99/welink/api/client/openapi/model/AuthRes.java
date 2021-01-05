package com.github.wangran99.welink.api.client.openapi.model;

import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 14:29
 * @description：
 */
@Data
@Component
public class AuthRes {
    private String access_token;
    private long expires_in;
}
