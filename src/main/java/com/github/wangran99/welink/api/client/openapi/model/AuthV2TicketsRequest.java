
package com.github.wangran99.welink.api.client.openapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author johntang
 */
public class AuthV2TicketsRequest {

    @SerializedName("client_id")
    private String clientId;
    @SerializedName("client_secret")
    private String clientSecret;

    public AuthV2TicketsRequest() {
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
