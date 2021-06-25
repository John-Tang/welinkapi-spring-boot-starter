package com.github.wangran99.welink.api.client.openapi.model;

import lombok.Data;

@Data
public class PredownloadRes {
    String file_sn;
    long size;
    String md5;
    String download_url;
}
