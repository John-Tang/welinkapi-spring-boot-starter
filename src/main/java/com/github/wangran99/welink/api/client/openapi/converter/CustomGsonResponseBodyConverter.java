package com.github.wangran99.welink.api.client.openapi.converter;


import com.github.wangran99.welink.api.client.openapi.Constant;
import com.github.wangran99.welink.api.client.openapi.exception.OpenApiException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.*;
import java.lang.annotation.Annotation;

/**
 * @author ：WangRan
 * @date ：Created in 2020/8/4 14:02
 * @description：
 */
@Slf4j
final class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private final Annotation[] annotations;

    CustomGsonResponseBodyConverter(Gson gson, Annotation[] annotations, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
        this.annotations = annotations;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        value.close();
        log.debug(response);
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader1 = new InputStreamReader(inputStream);
        JsonReader jsonReader = gson.newJsonReader(reader1);
        JsonObject jsonObject = JsonParser.parseReader(jsonReader).getAsJsonObject();
        int code = jsonObject.get("code") == null ? 0 : jsonObject.get("code").getAsInt();
        if (code != 0) {

            String message = null;
            if (code == Constant.INTERFACE_OVER_LIMIT) {
                message = "接口超限，请稍后再试";
            } else {
                message = "调用错误：" + jsonObject.get("errorMessage").getAsString();
            }

            OpenApiException e = new OpenApiException(code, message);
            throw e;
        }
        return adapter.fromJson(response);

    }
}