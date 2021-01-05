package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

@Data
public class DeptInfo {
    String corpDeptCode;   // 必填   客户侧部门唯一编码
    String corpParentCode; // 必填   客户侧上一级部门编码。注意：同步1级部门时该字段值设置为“0”
    String deptNameCn;     // 必填   部门中文名称
    String deptNameEn;     // 必填   部门英文名称
    String deptLevel;      // 非必填 部门级别。1：表示1级部门，2：表示二层部门，以此类推
    String managerId;      // 非必填 部门主管的ID
    String valid;          // 必填   部门状态。1：有效（有效根据是否存在corpDeptCode判断新增还是更新）； 0：无效（无效表示已删除）
    String orderNo;        // 非必填 部门排序。取值范围：1~999。按数值正序排列。默认为1000。
    int  visibleRange;     // 非必填 1、全部可见 2、仅自己可见 3、当前部门和子部门可见
}
