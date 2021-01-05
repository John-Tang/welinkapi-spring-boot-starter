package com.github.wangran99.welink.api.client.openapi.model;

import java.util.List;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 9:21
 * @description：
 */
@Data
public class QueryDepartmentInfoResPage {
    private int offset;
    private int limit;
    private int totalCount;
    List<DepartmentInfo> departmentInfo;
}
