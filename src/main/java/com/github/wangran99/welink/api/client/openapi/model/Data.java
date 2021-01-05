package com.github.wangran99.welink.api.client.openapi.model;

import java.util.List;

@lombok.Data
public class Data {
    List<Article> items;
    Page page;
}
