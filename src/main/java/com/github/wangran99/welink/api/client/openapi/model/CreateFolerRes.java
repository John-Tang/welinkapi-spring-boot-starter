package com.github.wangran99.welink.api.client.openapi.model;

import java.util.Date;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/19 16:20
 * @description：
 */
@Data
public class CreateFolerRes {
    Date createdAt;
    long createdBy;
    long id;
    boolean isEncrypt;
    Date modifiedAt;
    long modifiedBy;
    String name;
    long ownedBy;
    long parent;
    int status;
    int type;
    boolean isShare;
    boolean isSharelink;
    boolean isSync;
}
