package com.github.wangran99.welink.api.client.openapi;



import com.github.wangran99.welink.api.client.openapi.model.IsAdminRes;
import com.github.wangran99.welink.api.client.openapi.model.ManagerAuthRes;
import com.github.wangran99.welink.api.client.openapi.model.UserIdInfo;
import retrofit2.http.*;


/**
 * @author ：WangRan
 * @date ：Created in 2020/12/4 8:20
 * @description：web管理员页面welink认证接口（https://open.welink.huaweicloud.com/docs）
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
    ManagerAuthRes managerAuthorization(@Query("code")String code, @Query("grant_type") String grant_type, @Query("client_id")String client_id,
                                        @Query("client_secret")String client_secret, @Query("redirect_uri")String redirect_uri, @Query("state")String state);

    /**
     * 查询用户角色和管理员权限
     * @param wlk
     * @return
     */
    @GET("weopen/v1/isadmin")
    IsAdminRes isAdminAndRoles(@Header("x-wlk-Authorization") String wlk);

    /**
     * 查询用户id和租户id
     * @param wlk
     * @return
     */
    @GET("auth/v1/userid")
    UserIdInfo getUserId(@Header("x-wlk-Authorization") String wlk);
}
