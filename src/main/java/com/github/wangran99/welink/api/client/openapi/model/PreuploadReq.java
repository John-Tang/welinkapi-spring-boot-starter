package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Data;

@Data
public class PreuploadReq {
    String name;
    long size;
    String md5;
    String block_md5;
}
