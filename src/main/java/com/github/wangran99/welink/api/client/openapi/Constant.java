package com.github.wangran99.welink.api.client.openapi;

/**
 *
 * 常量表，主要是http header的name
 *
 */

public class Constant {

    /** WE码请求头中的用户AuthCode     */
    public static final String AUTH_CODE_HEADER = "authCode";

    /** 服务器返回需要重定向的标志header     */
    public static final String REDIRECT_URL_HEADER = "loginUrl";

    /** token缓存name      */
    public static final String CACHE_NAME_TOKEN = "access_token";

    /**请求头x-wlk-Authorization中的token */
    public static final String X_WLK_AUTHORIZATION = "x-wlk-Authorization";

    /**请求头  Authorization 中的token */
    public static final String AUTHORIZATION = "Authorization";

}