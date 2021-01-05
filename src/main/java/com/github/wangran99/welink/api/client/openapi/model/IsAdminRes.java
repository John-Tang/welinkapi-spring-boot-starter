package com.github.wangran99.welink.api.client.openapi.model;

import java.util.List;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/13 8:41
 * @description：
 */
@Data
public class IsAdminRes {
    private boolean isAdmin;
//    [“enterpriseAdmin”,“appStoreAdmin”, “appAdmin”] 返回值为列表中值的1个或者多个,
//    enterpriseAdmin表示为租户管理员,appStoreAdmin表示为租户内所有应用的管理员,appAdmin表示为该应用的责任人
    private List<String> roles;
}
