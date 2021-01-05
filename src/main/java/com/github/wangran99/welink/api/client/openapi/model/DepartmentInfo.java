package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 9:18
 * @description：
 */
@Data
public class DepartmentInfo {
    private String deptCode;
    private String deptNameCn;
    private String deptNameEn;
    private String fatherCode;
    private int deptLevel;
    private int orderNo;
    private int hasChildDept;
    private String corpDeptCode;
}
