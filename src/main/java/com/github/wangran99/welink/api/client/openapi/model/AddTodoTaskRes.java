package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddTodoTaskRes {
    String taskId;
    String uuid;
    String taskTitle;
    String userId;
    String userNameCn;
    String userNameEn;
    String detailsUrl;
    String appName;
    LocalDateTime lastModifyTime;
    LocalDateTime createTime;
    String tenantId;
    String applicantUserId;
    String applicantUserNameCn;
    String applicantUserNameEn;
    int isMsg;
    boolean isShowApplicantUserName;
    String applicantId;
}
