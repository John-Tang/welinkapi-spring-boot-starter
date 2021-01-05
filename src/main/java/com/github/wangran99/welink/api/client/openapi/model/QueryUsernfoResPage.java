package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Data;

import java.util.List;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 18:07
 * @description：根据部门code查询人员信息返回值
 */
@Data
public class QueryUsernfoResPage {
    private int pageNo;
    private int pages;
    private String pageSize;
    private int total;
    List<UserInfoRes> data;
}
