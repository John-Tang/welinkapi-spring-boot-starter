package com.github.wangran99.welink.api.client.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author johntang
 */
@Data
@ConfigurationProperties(prefix = "welink.openapi")
public class WeLinkOpenApiProperties {

    /**
     * API基址，必须以/结尾
     */
    private String baseUrl;
    private String clientId;
    private String clientSecret;
}
