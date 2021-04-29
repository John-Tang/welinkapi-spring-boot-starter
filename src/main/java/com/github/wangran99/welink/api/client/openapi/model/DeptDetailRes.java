package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DeptDetailRes {
    String deptCode; //部门Id, Key值
    String corpDeptCode; //客户侧部门Id, Key值
    String fatherCode;//上级部门ID
    String deptLevel;
    String corpParentCode;
    String deptNameCn; //部门中文名称
    String deptNameEn;  //部门英文名称
    List<String> managerId; //部门主管(员工帐号)
    List<String>  corpManagerId;
    String orderNo;
    Integer visibleRange;
    Integer hasChildDept;//当前部门是否有子级部门，0表示没有子级部门，1表示有子级部门。
    Map<String,String> ext;
}
