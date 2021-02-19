package com.github.wangran99.welink.api.client.autoconfigure;

import com.github.wangran99.welink.api.client.openapi.*;
import com.github.wangran99.welink.api.client.openapi.model.AuthReq;
import com.github.wangran99.welink.api.client.openapi.model.AuthRes;
import com.github.wangran99.welink.api.client.openapi.model.TenantInfoRes;
import com.github.wangran99.welink.api.client.properties.WelinkOpenApiProperties;
import com.github.wangran99.welink.api.client.timer.AuthorizationTimer;
import com.google.gson.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Slf4j
@Data
@Configuration
@EnableConfigurationProperties(WelinkOpenApiProperties.class)
//@ConditionalOnProperty(prefix = "welink.openapi",value = "enabled", matchIfMissing = true)
public class WelinkOpenApiAutoConfiguration {

    private final String baseUrl = "https://open.welink.huaweicloud.com/api/";

    final static private String patten = "yyyy-MM-dd HH:mm:ss";
    //序列化
    final static JsonSerializer<LocalDateTime> jsonSerializerDateTime = (localDateTime, type, jsonSerializationContext) -> new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern(patten)));
    final static JsonSerializer<LocalDate> jsonSerializerDate = (localDate, type, jsonSerializationContext) -> new JsonPrimitive(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    //反序列化
    final static JsonDeserializer<LocalDateTime> jsonDeserializerDateTime = (jsonElement, type, jsonDeserializationContext) -> LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern(patten));
    final static JsonDeserializer<LocalDate> jsonDeserializerDate = (jsonElement, type, jsonDeserializationContext) -> LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);

    @Autowired
    private WelinkOpenApiProperties welinkOpenApiProperties;

//    @Autowired
//    CustomGsonConverterFactory customGsonConverterFactory;


    CustomGsonConverterFactory customGsonConverterFactory() {
        return new CustomGsonConverterFactory(gson());
    }

    @Bean
     Gson gson(){
        return new GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .setDateFormat(patten)
                /* 更改先后顺序没有影响 */
                .registerTypeAdapter(LocalDateTime.class, jsonSerializerDateTime)
                .registerTypeAdapter(LocalDate.class, jsonSerializerDate)
                .registerTypeAdapter(LocalDateTime.class, jsonDeserializerDateTime)
                .registerTypeAdapter(LocalDate.class, jsonDeserializerDate)
                .create();
    }
    @Bean
    AuthorizationTimer authorizationTimer() {
        return new AuthorizationTimer();
    }

    @Bean
    AuthReq authReq() {
        AuthReq req = new AuthReq();
        req.setClient_id(welinkOpenApiProperties.getClientId());
        req.setClient_secret(welinkOpenApiProperties.getClientSecret());
        return req;
    }

    @Bean
    AuthRes authRes() {
        AuthRes res = new AuthRes();
        return res;
    }

    @Bean
    TenantInfoRes tenantInfoRes() {
        TenantInfoRes tenantInfoRes = new TenantInfoRes();
        return tenantInfoRes;
    }

    /**
     * 获取Retrofit单例Bean
     *
     * @return
     */
    public Retrofit getRetrofit() {
        /**
         * setEndpoint("http://127.0.0.1:31111"):指定基本的URL，
         * API接口中的URL是相对于该URL的路径的，
         * 不能少了协议名，例如写成：localhost:8081就不行
         */
        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(10, 1, TimeUnit.SECONDS))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl).client(okHttpClient)
                .addCallAdapterFactory(new SynchronousCallAdapterFactory())
                .addConverterFactory(customGsonConverterFactory())
                .build();
        return retrofit;
    }

    @Bean
    public OpenAPI openAPI() {
        return getRetrofit().create(OpenAPI.class);
    }

//    @Bean
//    public OneBoxAPI oneBoxAPI() {
//        return getRetrofit().create(OneBoxAPI.class);
//    }

    @Bean
    public OpenManagerApi openManagerApi() {
        return getRetrofit().create(OpenManagerApi.class);
    }


}
