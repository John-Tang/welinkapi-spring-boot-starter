package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

@Data
public class DeptRead {
    String corpDeptCode;   //        客户侧部门唯一编码
    String deptUrl;        // 必填   部门全路径
    String orderNo;        // 非必填 部门排序。取值范围：1~999。按数值正序排列。默认为1000。
    String type;           // 操作类型 （1）新增，当该部门为新增时。（2）修改，当该部门需要修改名称时。（3）当该部门删除时。
    String permission;     // 通讯录权限：权限类型为三种，（1）可查看所有员工(当添加或更新部门非一级部门时，为继承上级部门权限设置)，（2）仅能查看自己，（3）可查看本部门及下级部门；当未填写时，默认为权限 （1）。



    int  visibleRange;     // 非必填 1、全部可见 2、仅自己可见 3、当前部门和子部门可见
    String deptNameCn;     // 必填   部门中文名称
    String deptNameEn;     // 必填   部门英文名称
    String deptLevel;      // 非必填 部门级别。1：表示1级部门，2：表示二层部门，以此类推
    String managerId;      // 非必填 部门主管的ID
    String valid;          // 必填   部门状态。1：有效（有效根据是否存在corpDeptCode判断新增还是更新）； 0：无效（无效表示已删除）
}
