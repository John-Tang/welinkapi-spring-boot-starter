//package com.github.wangran99.welink.api.client.openapi;
//
//import com.google.gson.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Configuration
//public class GsonConfig {
//    final static private String patten = "yyyy-MM-dd HH:mm:ss";
//    //序列化
//    final static JsonSerializer<LocalDateTime> jsonSerializerDateTime = (localDateTime, type, jsonSerializationContext) -> new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern(patten)));
//    final static JsonSerializer<LocalDate> jsonSerializerDate = (localDate, type, jsonSerializationContext) -> new JsonPrimitive(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
//    //反序列化
//    final static JsonDeserializer<LocalDateTime> jsonDeserializerDateTime = (jsonElement, type, jsonDeserializationContext) -> LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern(patten));
//    final static JsonDeserializer<LocalDate> jsonDeserializerDate = (jsonElement, type, jsonDeserializationContext) -> LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
//
//    @Bean
//    public Gson gson(){
//        return new GsonBuilder()
//                .setLenient()
//                .setPrettyPrinting()
//                .setDateFormat(patten)
//                /* 更改先后顺序没有影响 */
//                .registerTypeAdapter(LocalDateTime.class, jsonSerializerDateTime)
//                .registerTypeAdapter(LocalDate.class, jsonSerializerDate)
//                .registerTypeAdapter(LocalDateTime.class, jsonDeserializerDateTime)
//                .registerTypeAdapter(LocalDate.class, jsonDeserializerDate)
//                .create();
//    }
//}
