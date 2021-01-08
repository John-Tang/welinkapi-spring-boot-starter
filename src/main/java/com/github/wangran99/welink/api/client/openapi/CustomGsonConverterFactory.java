package com.github.wangran99.welink.api.client.openapi;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 10:19
 * @description：自定义Gson对不同类的序列化方式
 */
@Slf4j
public class CustomGsonConverterFactory extends Converter.Factory {

    final static private String patten = "yyyy-MM-dd HH:mm:ss";

    private  Gson gson;

    public CustomGsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        String host = retrofit.baseUrl().host();
        //welink开放平台时的解析器
//        if (host.contains("open.welink.huaweicloud.com")) {
            TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
            return new CustomGsonResponseBodyConverter<>(gson, adapter);
//        } else {//OneBox请求时候的解析器
//            TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
//            return new CustomOneBoxResponseBodyConverter<>(gson, adapter);
//        }
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new CustomGsonRequestBodyConverter<>(gson, adapter);
    }
}