package com.github.wangran99.welink.api.client.openapi;





import com.github.wangran99.welink.api.client.openapi.model.*;
import retrofit2.http.*;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 8:20
 * @description：
 */

public interface OpenAPI {

    /**
     * 鉴权，获取token.A租户的token不能用户获取B租户的各种信息，如人员，部门等
     * @param authReq 不同租户的传递的租户id是不同的，得到的token也是不同
     * @return
     */
    @POST("auth/v2/tickets")
    @Headers({"Content-Type:application/json"})
    AuthRes auth(@Body AuthReq authReq);

    /**
     * 获取租户信息
     *
     * @param accessToken （不同租户提供的accessToken是不同的）
     * @return
     */
    @GET("tenant/v1/tenants")
    @Headers({"Content-Type:application/json"})
    TenantInfoRes getTenantInfo(@Header("x-wlk-Authorization") String accessToken);

    /**
     * 根据we码中获得authCode获取用户id和租户信息
     * @param accessToken 本we码获鉴权得到的accessToken
     * @param authCode
     * @return
     */
    @GET("auth/v2/userid")
    UserIdInfo getUserBasicIdInfo(@Header("x-wlk-Authorization") String accessToken, @Query("code") String authCode);

    /**
     * 轻应用鉴权
     * @param accessToken
     * @return
     */
    @GET("auth/v1/jstickets")
    JsticketsRes jsAuth(@Header("x-wlk-Authorization") String accessToken);

    @POST("contact/v3/users/simple")
    @Headers({"Content-Type:application/json"})
    UserBasicInfoRes getUserBasicInfo(@Header("x-wlk-Authorization") String accessToken, @Body UserBasicInfoReq userBasicInfoReq);

    @POST("contact/v3/users")
    @Headers({"Content-Type:application/json"})
    UserBasicInfoRes getUserBasicInfoById(@Header("x-wlk-Authorization") String accessToken, @Query("userId") String userBasicInfoReq);

    @GET("contact/v1/departments/{deptCode}")
    DeptDetailRes getDeptDetail(@Header("x-wlk-Authorization") String accessToken, @Path("deptCode") String deptCode);

    @GET("weopen/v1/isadmin")
    IsAdminRes isAdminAndRoles(@Header("x-wlk-Authorization") String accessToken, @Query("userId") String userId);

    @POST("todo/v1/addtask")
    AddTodoTaskRes addTodoTask(@Header("x-wlk-Authorization") String accessToken, @Body AddTodoTaskReq addTodoTaskReq);

    @DELETE("todo/v1/deltask")
    Void delTodoTask(@Header("x-wlk-Authorization") String accessToken, @Query("taskId") String taskId);

    @GET("contact/v3/departments/list")
    QueryDepartmentInfoResPage getSubDept(@Header("x-wlk-Authorization") String accessToken, @Query("deptCode") String deptCode, @Query("recursiveflag") int recursiveflag, @Query("offset") int offset, @Query("limit") int limit);

    @GET("contact/v1/user/users")
    QueryUsernfoResPage getUsersByDeptCode(@Header("x-wlk-Authorization") String accessToken, @Query("deptCode") String deptCode, @Query("pageNo") String pageNum,@Query("pageSize") String pageSize);

    @POST("attendance/v2/records")
    QueryPunchCardResPage getPunchCardByCorpId(@Header("x-wlk-Authorization") String accessToken, @Body QueryPunchCardReq req);

    //批量异步同步人员信息
    @POST("contact/v2/users/bulk")
    SyncUsersRes syncUsers(@Header("x-wlk-Authorization") String accessToken, @Body SyncUsersReq req);
    //删除人员信息
    @POST("contact/v1/user/delete")
    Object delUser(@Header("x-wlk-Authorization") String accessToken, @Body DelUserReq req);
    //批量异步更新人员信息
    @POST("contact/v2/users/update")
    SyncUsersRes updateUsers(@Header("x-wlk-Authorization") String accessToken, @Body SyncUsersReq req);
    //查询异步批量同步用户的结果
    @POST("contact/v1/users/status")
    SyncUsersRes syncUserStatus(@Header("x-wlk-Authorization") String accessToken, @Body SyncUsersReq req);

    //修改用户绑定手机号，此接口实时返回修改结果。同一个已开户状态用户24小时之内只允许修改手机号3次，未开户状态用户无限制。
    @PUT("contact/v1/user/mobilenumber")
    Void updateUserPhone(@Header("x-wlk-Authorization") String accessToken, @Body UpdateUserPhoneReq req);

    //批量异步同步部门信息
    @POST("contact/v2/departments/bulk")
    SyncDepartmentsRes syncDepartments(@Header("x-wlk-Authorization") String accessToken, @Body SyncDeptReq req);
    //删除部门信息
    @POST("contact/v1/department/delete")
    Object delDepartment(@Header("x-wlk-Authorization") String accessToken, @Body DelDeptReq req);
    //批量异步更新部门信息
    @POST("contact/v2/departments/update")
    SyncDepartmentsRes updateDepartments(@Header("x-wlk-Authorization") String accessToken, @Body SyncDeptReq req);
    //查询异步批量同步部门的结果。
    @POST("contact/v2/departments/status")
    SyncDepartmentsRes syncDepartmentStatus(@Header("x-wlk-Authorization") String accessToken, @Body SyncDeptReq req);

    //该接口用于企业应用中需要消息通知的场景。通过本接口，应用可以将信息推送给WeLink端用户。
    @POST("messages/v3/send")
    Void sendOfficialAccountMsg(@Header("x-wlk-Authorization") String accessToken, @Body SendOfficialAccountMsgReq req);

}