package com.github.wangran99.welink.api.client.openapi;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.springframework.lang.Nullable;

/**
 * @author ：WangRan
 * @date ：Created in 2020/12/19 17:23
 * @description：proxyfactory，用来动态替换retrofit的baseUrl
 */
@Slf4j
public abstract class CallFactoryProxy implements Call.Factory {
    private static final String NAME_BASE_URL = "BaseUrlName";
    private final Call.Factory delegate;

    public CallFactoryProxy(Call.Factory delegate) {
        this.delegate = delegate;
    }

    @Override
    public Call newCall(Request request) {
        String baseUrlName = request.header(NAME_BASE_URL);
        if (baseUrlName != null) {
            HttpUrl newHttpUrl = getNewUrl(baseUrlName, request);
            if (newHttpUrl != null) {
                Request newRequest = request.newBuilder().url(newHttpUrl).build();
                return delegate.newCall(newRequest);
            } else {
                log.info( "getNewUrl() return null when baseUrlName==" + baseUrlName);
            }
        }
        return delegate.newCall(request);
    }

    @Nullable
    protected abstract HttpUrl getNewUrl(String baseUrlName, Request request);
}