package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

@Data
public class Page {
    int current_page_num;
    int page_size;
    int total;
    int total_page_num;
}
