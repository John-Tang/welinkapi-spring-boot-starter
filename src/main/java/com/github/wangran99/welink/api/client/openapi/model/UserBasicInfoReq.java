package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/12/12 17:30
 * @description：
 */
@Data
@Builder
public class UserBasicInfoReq {
    String userId;//查询用户信息，三个字段任选其一即可查询
    String mobileNumber;
    String corpUserId;
}
