package com.github.wangran99.welink.api.client.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "welink.openapi")
public class WelinkOpenApiProperties {
    private String clientId;
    private String clientSecret;
}
