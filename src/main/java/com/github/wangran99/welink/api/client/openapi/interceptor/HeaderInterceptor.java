package com.github.wangran99.welink.api.client.openapi.interceptor;

import cn.hutool.core.collection.CollUtil;
import com.huawei.welink.api.accesstoken.AuthV2TicketsResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;


/**
 * @author ：WangRan
 * @date ：Created in 2020/12/4 8:20
 * @description：对welink的请求增加统一的http header
 */
@Slf4j
public class HeaderInterceptor implements Interceptor {

    @Autowired
    private AuthV2TicketsResponse authRes;

    private static final String AUTH_HEADER = "x-wlk-Authorization";

    @Override
    public Response intercept(Chain chain) throws IOException {
        List<String> list = chain.request().headers(AUTH_HEADER);

        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Connection", "KeepAlive");

        if (CollUtil.isEmpty(list)) {
            builder.addHeader(AUTH_HEADER, authRes.getAccessToken() == null ? "" : authRes.getAccessToken());
        }

        Request request = builder.build();

        return chain.proceed(request);
    }
}
