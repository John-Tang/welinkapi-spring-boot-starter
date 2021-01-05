package com.github.wangran99.welink.api.client.openapi.model;

import java.util.List;
import lombok.Data;

@Data
public class SyncUsersRes {
    List<SyncUserResItem> data;
}
