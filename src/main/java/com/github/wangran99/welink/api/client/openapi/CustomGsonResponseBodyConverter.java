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
 * @author ：Wang
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
        log.debug(response);
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader1 = new InputStreamReader(inputStream);
        JsonReader jsonReader = gson.newJsonReader(reader1);
        JsonObject jsonObject = JsonParser.parseReader(jsonReader).getAsJsonObject();//
        int code = jsonObject.get("code") == null ? 0 : jsonObject.get("code").getAsInt();// 返回的数据转为JsonObject
//        String msg = jsonObject.get("message").getAsString();
        if (code != 0 && code != 60001 && code != 58003 && code != 47012 && code != 47009) { //查询用户不是管理员
            OpenApiException e = new OpenApiException(code, "open api error.");
            throw e;
        }
        InputStream inputStream1 = new ByteArrayInputStream(response.getBytes());
        Reader reader2 = new InputStreamReader(inputStream1);
        JsonReader jsonReader2= gson.newJsonReader(reader2);

        try {
            return adapter.read(jsonReader2);
        } finally {
            value.close();
        }
    }
}