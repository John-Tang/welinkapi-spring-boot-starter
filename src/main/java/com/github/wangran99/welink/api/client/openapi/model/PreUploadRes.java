package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/19 16:49
 * @description：
 */
@Data
public class PreUploadRes {
    String file_sn;
    String upload_url;
    String name;
    String object_id;
    long size;
    String md5;
    long created_at;
    long modified_at;
}
