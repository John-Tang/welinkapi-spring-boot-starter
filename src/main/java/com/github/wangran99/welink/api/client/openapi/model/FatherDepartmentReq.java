package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Data;

@Data
public class FatherDepartmentReq {
  String deptCode;
  Integer type; //0表示指定部门父部门列表只会使用参数deptCode和corpDeptCode；1表示指定用户父部门列表只会使用参数userId、corpUserId和mobileNumber
}
