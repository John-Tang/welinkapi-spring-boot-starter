package com.github.wangran99.welink.api.client.openapi.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/12 17:25
 * @description：
 */
@Data
public class UserBasicInfoRes {
    private String userStatus;      //状态, 1：未开户，2：开户中，3：已开户，4：已销户
    private String userId;      //用户帐号, Key值
    private String corpUserId;             //用户工号(集成用的字段，如果在开户时没有维护则为空)
    private String mainDeptCode;                   //部门Id, Key值, 必填
    private String mainCorpDeptCode;                   //部门Id, Key值, 必填
    private List<String> deptCodes;
    private List<String> corpDeptCodes;
    private String mobileNumber;     //绑定手机号码, 必填
    private String avatar;
    private String employeeId;
    private String businessAddress;
    private String baseLocation;
    private String position;
    private List<String> phoneNumber;    //手机号码
    private String landlineNumber;    //电话号码(座机)
    private String userNameCn;                //用户中文名称, 必填
    private String userNameEn;            //用户英文名称, 必填
    private String sex;                          //性别, 仅：M/F, M: 男, F: 女, 必填
    private String userEmail;   //用户邮箱, 必填
    private String secretary;   //秘书(用户帐号)
    private String corpSecretary;
    private String address;              //地址
    private String remark;       //备注
    private LocalDateTime creationTime;  //创建时间
    private LocalDateTime lastUpdatedTime;
    private Integer isActivated;
    private Integer isAdmin;//是否为企业的管理员，1表示是，0表示不是(默认)
    private String sipNum;//WeLink会议软终端号码
    private List<String> roleIds;//当员工存在多个角色中时，设置多个角色编码
    private Map extAttr;
    TenantInfoRes tenantInfoRes;
    DeptDetailRes deptDetailRes;
    private IsAdminRes isAdminRes;
}
