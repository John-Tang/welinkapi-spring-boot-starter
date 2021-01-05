package com.github.wangran99.welink.api.client.openapi;



import com.github.wangran99.welink.api.client.openapi.model.IsAdminRes;
import com.github.wangran99.welink.api.client.openapi.model.ManagerAuthRes;
import com.github.wangran99.welink.api.client.openapi.model.UserIdInfo;
import retrofit2.http.*;

/**
 * web管理员页面welink认证接口
 */
public interface OpenManagerApi {

    /**
     * 应用管理后台免登鉴权获取token
     * @param code
     * @param grant_type
     * @param client_id
     * @param client_secret
     * @param redirect_uri
     * @param state
     * @return
     */
    @POST("oauth2/v1/token")
    @Headers({"Content-Type:application/json"})
    ManagerAuthRes managerAuthorization(@Query("code")String code, @Query("grant_type") String grant_type, @Query("client_id")String client_id,
                                        @Query("client_secret")String client_secret, @Query("redirect_uri")String redirect_uri, @Query("state")String state);

    @GET("weopen/v1/isadmin")
    @Headers({"Content-Type:application/json"})
    IsAdminRes isadmin(@Header("x-wlk-Authorization") String wlk);

    @GET("auth/v1/userid")
    @Headers({"Content-Type:application/json"})
    UserIdInfo getUserId(@Header("x-wlk-Authorization") String wlk);
}
