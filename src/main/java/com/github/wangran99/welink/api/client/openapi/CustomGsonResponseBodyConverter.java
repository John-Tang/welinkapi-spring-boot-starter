package com.github.wangran99.welink.api.client.openapi;


import com.github.wangran99.welink.api.client.openapi.model.OpenApiException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.*;

/**
 * @author ：WangRan
 * @date ：Created in 2020/8/4 14:02
 * @description：
 */
@Slf4j
final class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        value.close();
        log.debug(response);
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader1 = new InputStreamReader(inputStream);
        JsonReader jsonReader = gson.newJsonReader(reader1);
        JsonObject jsonObject = JsonParser.parseReader(jsonReader).getAsJsonObject();//
        int code = jsonObject.get("code") == null ? 0 : jsonObject.get("code").getAsInt();// 返回的数据转为JsonObject
//        String msg = jsonObject.get("message").getAsString();
        if (code != 0 && code != 60001 && code != 58003 && code != 47012 && code != 47009) { //查询用户不是管理员
            OpenApiException e = new OpenApiException(code, "open api error." + jsonObject.get("message").getAsString());
            throw e;
        }
        //没有data，直接有分页
        if (jsonObject.get("data") == null && jsonObject.get("limit") != null)
            return adapter.fromJson(response);
        //data为空或者有分页查询的情况
        if (jsonObject.get("data") == null || jsonObject.get("data") != null && jsonObject.get("pageNo") != null)
            return adapter.fromJson(response);


        if (jsonObject.get("data").isJsonArray()) {
            return adapter.fromJson(jsonObject.get("data").getAsJsonArray().toString());
        }else
            return adapter.fromJsonTree(jsonObject.get("data").getAsJsonObject());

    }
}