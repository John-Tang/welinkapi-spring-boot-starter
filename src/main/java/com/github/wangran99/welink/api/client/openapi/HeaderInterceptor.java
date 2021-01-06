package com.github.wangran99.welink.api.client.openapi;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpHeaders;

import java.io.IOException;


 /**
 * @author ：WangRan
 * @date ：Created in 2020/12/4 8:20
 * @description：对welink的请求增加统一的http header
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader(HttpHeaders.CONNECTION, "close")
                .build();
        Response response =  chain.proceed(request);

        return response;
    }
}
