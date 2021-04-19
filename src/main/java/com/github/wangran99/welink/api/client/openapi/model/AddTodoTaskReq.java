package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Builder;
import lombok.Data;

@Data
public class AddTodoTaskReq {
    String taskId;
    String taskTitle;
    String userId;
    String userNameCn;
    String userNameEn;
    String detailsUrl;
    String appName;
    String applicantUserId;
    String applicantUserNameCn;
    String applicantUserNameEn;
    int isMsg;
    boolean isShowApplicantUserName;
    String applicantId;
}
