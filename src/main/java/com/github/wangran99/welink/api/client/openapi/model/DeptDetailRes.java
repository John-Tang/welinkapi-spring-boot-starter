package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Data;

@Data
public class DeptDetailRes {
    String deptCode; //部门Id, Key值
    String corpDeptCode; //客户侧部门Id, Key值
    String deptNameCn; //部门中文名称
    String deptNameEn;  //部门英文名称
    String parentCode; //上级部门ID
    String managerAccount; //部门主管(员工帐号)
}
