package com.github.wangran99.welink.api.client.openapi.model;

import java.util.List;
import lombok.Data;

@Data
public class SendOfficialAccountMsgReq {
    String msgRange;
    List<String> toUserList;
    String msgTitle;
    String msgContent;
    String urlType;
    String urlPath;
    String msgOwner;
    String createTime;
}
