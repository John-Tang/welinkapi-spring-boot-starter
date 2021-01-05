package com.github.wangran99.welink.api.client.openapi.model;

import java.util.List;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 18:25
 * @description：
 */
@Data
public class QueryPunchCardReq {
    private int offset;
    private List<String> userIdList;
    private String dateFrom;
    private String dateTo;
    private int limit;
}
