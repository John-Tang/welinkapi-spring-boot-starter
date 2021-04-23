package com.github.wangran99.welink.api.client.openapi;

import com.github.wangran99.welink.api.client.openapi.model.AuthRes;
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
    private AuthRes authRes;

    @Override
    public Response intercept(Chain chain) throws IOException {
        List<String> list = chain.request().headers("x-wlk-Authorization");
        Request request = null;
        if (list.isEmpty())
            request = chain.request().newBuilder()
                    .addHeader("Connection", "close")
                    .addHeader("x-wlk-Authorization", authRes.getAccess_token() == null ? "" : authRes.getAccess_token())
                    .build();
        else
            request = chain.request().newBuilder()
                    .addHeader("Connection", "close").build();
        Response response = chain.proceed(request);

        return response;
    }
}
