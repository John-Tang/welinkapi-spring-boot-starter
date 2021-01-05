package com.github.wangran99.welink.api.client.openapi.model;

import java.util.List;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 18:22
 * @description：
 */
@Data
public class QueryPunchCardResPage {
    private int totalCount;
    private int limit;
    private int offset;
    List<PunchCard> records;
}
