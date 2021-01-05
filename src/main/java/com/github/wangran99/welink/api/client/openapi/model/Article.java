package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

@Data
public class Article {
    String articles_global_id;
    String content_type;
    String title;
    String cover_img;
    String author_account;
    String author_name_cn;
    String article_id;
    String category_name_cn;
    String rec_data_name_cn;
    String pub_time;
    String link;
    String pc_url;
    int view_count;
    int comment_count;
}
