package com.github.wangran99.welink.api.client.openapi.model;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 18:18
 * @description：
 */
@Data
public class PunchCard {
    private String id;
    private String userId;
    private String corpUserId;
    private String userNameCn;

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkTime;
    private String location;
    private String longitude;
    private String latitude;
}
