package com.github.wangran99.welink.api.client.autoconfigure;

import com.github.wangran99.welink.api.client.openapi.SynchronousCallAdapterFactory;
import com.github.wangran99.welink.api.client.openapi.api.WeLinkApiV2;
import com.github.wangran99.welink.api.client.openapi.converter.CustomGsonConverterFactory;
import com.github.wangran99.welink.api.client.openapi.interceptor.HeaderInterceptor;
import com.github.wangran99.welink.api.client.openapi.model.AuthV2TicketsRequest;
import com.github.wangran99.welink.api.client.properties.WeLinkOpenApiProperties;
import com.github.wangran99.welink.api.client.timer.AuthorizationTimer;
import com.google.gson.*;
import com.huawei.welink.api.accesstoken.AuthV2TicketsResponse;
import com.huawei.welink.api.tenant.TenantV1TenantsResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author johntang
 */
@Slf4j
@Data
@Configuration
@EnableConfigurationProperties(WeLinkOpenApiProperties.class)
public class WeLinkOpenApiAutoConfiguration {

    final static private String patten = "yyyy-MM-dd HH:mm:ss";
    /**
     * 序列化
     */
    final static JsonSerializer<LocalDateTime> jsonSerializerDateTime = (localDateTime, type, jsonSerializationContext) -> new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern(patten)));
    final static JsonSerializer<LocalDate> jsonSerializerDate = (localDate, type, jsonSerializationContext) -> new JsonPrimitive(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    /**
     * 反序列化
     */
    final static JsonDeserializer<LocalDateTime> jsonDeserializerDateTime = (jsonElement, type, jsonDeserializationContext) -> LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern(patten));
    final static JsonDeserializer<LocalDate> jsonDeserializerDate = (jsonElement, type, jsonDeserializationContext) -> LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);

    @Resource
    private WeLinkOpenApiProperties welinkOpenApiProperties;


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
    AuthV2TicketsRequest authV2TicketsRequest() {
        AuthV2TicketsRequest req = new AuthV2TicketsRequest();
        req.setClientId(welinkOpenApiProperties.getClientId());
        req.setClientSecret(welinkOpenApiProperties.getClientSecret());
        return req;
    }

    @Bean
    AuthV2TicketsResponse authV2TicketsResponse() {
        AuthV2TicketsResponse res = new AuthV2TicketsResponse();
        return res;
    }

    @Bean
    TenantV1TenantsResponse tenantV1TenantsResponse() {
        TenantV1TenantsResponse tenantV1TenantsResponse = new TenantV1TenantsResponse();
        return tenantV1TenantsResponse;
    }

    @Bean
    HeaderInterceptor headerInterceptor(){
        return new HeaderInterceptor();
    }

    /**
     * 获取Retrofit单例Bean
     *
     * @return
     */
    @Bean
    public Retrofit getRetrofit(HeaderInterceptor headerInterceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(10, 30, TimeUnit.SECONDS))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(welinkOpenApiProperties.getBaseUrl()).client(okHttpClient)
                .addCallAdapterFactory(new SynchronousCallAdapterFactory())
                .addConverterFactory(customGsonConverterFactory())
                .build();
        return retrofit;
    }

    /**
     * 开放平台接口v2
     * @param retrofit
     * @return
     */
    @Bean
    public WeLinkApiV2 weLinkApiV2(Retrofit retrofit) {
        return retrofit.create(WeLinkApiV2.class);
    }

}
