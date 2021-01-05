package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

@Data
public class ArticleDetail {
    String author_account;
    String author_name_cn;
    String content;
    String cover_img;
    String title;
    long view_count;
    long pub_time;
}
