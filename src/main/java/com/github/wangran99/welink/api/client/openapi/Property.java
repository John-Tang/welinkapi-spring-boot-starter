package com.github.wangran99.welink.api.client.openapi;

/**
 *
 * 常量表，主要是http header的name
 *
 */

public class Property {

    /** WE码请求头中的用户AuthCode     */
    public static final String AUTH_CODE_HEADER = "authCode";

    /** 服务器返回需要重定向的标志header     */
    public static final String REDIRECT_URL_HEADER = "loginUrl";

    /** 通讯录缓存name      */
    public static final String CACHE_NAME_CONTACT = "wecontact_info";

    /** token缓存name      */
    public static final String CACHE_NAME_TOKEN = "access_token";

    /** area位置缓存name      */
    public static final String CACHE_NAME_AREA = "area_info";

    /** 数据字典缓存name      */
    public static final String CACHE_NAME_PROPERTY = "property_info";

    /**请求头x-wlk-Authorization中的token */
    public static final String X_WLK_AUTHORIZATION = "x-wlk-Authorization";

    public static final String REDIS_USER_INFO = "notice:userInfo:";

    public static final String REDIS_TENANT_TOKEN = "attendance:tenantToken:";

    public static final String REDIS_MATTEND_GPS = "attendance:mattendgps:";

    /**请求头  Authorization 中的token */
    public static final String AUTHORIZATION = "Authorization";


}