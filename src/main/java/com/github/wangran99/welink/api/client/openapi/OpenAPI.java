package com.github.wangran99.welink.api.client.openapi;

import com.github.wangran99.welink.api.client.openapi.model.*;
import retrofit2.http.*;

/**
 * @author ：WangRan
 * @date ：Created in 2020/12/4 8:20
 * @description：welink开放平台接口（https://open.welink.huaweicloud.com/docs）
 */

public interface OpenAPI {

    /**
     * welink开放平台鉴权，获取token。A租户的token不能用户获取B租户的各种信息，如人员，部门等
     * @param authReq 不同租户的传递的租户id是不同的，得到的token也是不同
     * @return
     */
    @POST("auth/v2/tickets")
    @Headers({"Content-Type:application/json"})
    AuthRes auth(@Body AuthReq authReq);

    /**
     * 获取租户信息
     * @param accessToken （不同租户提供的accessToken是不同的）
     * @return
     */
    @GET("tenant/v1/tenants")
    @Headers({"Content-Type:application/json"})
    TenantInfoRes getTenantInfo(@Header("x-wlk-Authorization") String accessToken);

    /**
     * 根据we码中获得authCode获取用户id和租户信息
     * @param accessToken 本we码获鉴权得到的accessToken
     * @param authCode 免登授权码
     * @return 用户id和租户id
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

    /**
     * 通过用户id，电话，职工编号获取用户简略信息
     * @param accessToken
     * @param userBasicInfoReq
     * @return
     */
    @POST("contact/v3/users/simple")
    UserBasicInfoRes getUserBasicInfo(@Header("x-wlk-Authorization") String accessToken, @Body UserBasicInfoReq userBasicInfoReq);

    /**
     * 根据用户ID获取详细信息
     * @param accessToken
     * @param userId
     * @return
     */
    @POST("contact/v3/users")
    UserBasicInfoRes getUserInfoById(@Header("x-wlk-Authorization") String accessToken, @Query("userId") String userId);

    /**
     * 根据用户手机号获取详细信息
     * @param accessToken
     * @param mobileNumber
     * @return
     */
    @POST("contact/v3/users")
    UserBasicInfoRes getUserInfoByMobileNumber(@Header("x-wlk-Authorization") String accessToken, @Query("mobileNumber") String mobileNumber);

    /**
     * 根据用户员工号获取详细信息
     * @param accessToken
     * @param corpUserId
     * @return
     */
    @POST("contact/v3/users")
    UserBasicInfoRes getUserInfoByCorpUserId(@Header("x-wlk-Authorization") String accessToken, @Query("corpUserId") String corpUserId);

    /**
     * 获取部门详情
     * @param accessToken
     * @param deptCode
     * @return
     */
    @GET("contact/v1/departments/{deptCode}")
    DeptDetailRes getDeptDetail(@Header("x-wlk-Authorization") String accessToken, @Path("deptCode") String deptCode);

    /**
     * 获取用户角色和权限
     * @param accessToken
     * @param userId
     * @return
     */
    @GET("weopen/v1/isadmin")
    IsAdminRes isAdminAndRoles(@Header("x-wlk-Authorization") String accessToken, @Query("userId") String userId);

    /**
     * 添加待办事项
     * @param accessToken
     * @param addTodoTaskReq
     * @return
     */
    @POST("todo/v1/addtask")
    AddTodoTaskRes addTodoTask(@Header("x-wlk-Authorization") String accessToken, @Body AddTodoTaskReq addTodoTaskReq);

    /**
     * 删除待办
     * @param accessToken
     * @param taskId
     * @return
     */
    @DELETE("todo/v1/deltask")
    Void delTodoTask(@Header("x-wlk-Authorization") String accessToken, @Query("taskId") String taskId);

    /**
     * 获取子部门信息
     * @param accessToken
     * @param deptCode
     * @param recursiveflag 是否递归查询
     * @param offset
     * @param limit
     * @return
     */
    @GET("contact/v3/departments/list")
    QueryDepartmentInfoResPage getSubDept(@Header("x-wlk-Authorization") String accessToken, @Query("deptCode") String deptCode, @Query("recursiveflag") int recursiveflag, @Query("offset") int offset, @Query("limit") int limit);

    /**
     * 获取部门人员列表
     * @param accessToken
     * @param deptCode
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GET("contact/v1/user/users")
    QueryUsernfoResPage getUsersByDeptCode(@Header("x-wlk-Authorization") String accessToken, @Query("deptCode") String deptCode, @Query("pageNo") String pageNum,@Query("pageSize") String pageSize);

    /**
     * 获取考勤打卡信息
     * @param accessToken
     * @param req
     * @return
     */
    @POST("attendance/v2/records")
    QueryPunchCardResPage getPunchCardByCorpId(@Header("x-wlk-Authorization") String accessToken, @Body QueryPunchCardReq req);

    /**
     * 批量异步同步人员信息
     * @param accessToken
     * @param req
     * @return
     */
    @POST("contact/v2/users/bulk")
    SyncUsersRes syncUsers(@Header("x-wlk-Authorization") String accessToken, @Body SyncUsersReq req);

    /**
     * 批量异步更新人员信息
     * @param accessToken
     * @param req
     * @return
     */
    @PUT("contact/v2/users/update")
    SyncUsersRes updateUsers(@Header("x-wlk-Authorization") String accessToken, @Body SyncUsersReq req);

    /**
     * 查询异步批量同步用户的结果
     * @param accessToken
     * @param req
     * @return
     */
    @POST("contact/v1/users/status")
    SyncUsersRes syncUserStatus(@Header("x-wlk-Authorization") String accessToken, @Body SyncUsersReq req);

    /**
     * 修改用户绑定手机号，此接口实时返回修改结果。
     * 同一个已开户状态用户24小时之内只允许修改手机号3次，未开户状态用户无限制。
     * @param accessToken
     * @param req
     * @return
     */
    @PUT("contact/v1/user/mobilenumber")
    Void updateUserPhone(@Header("x-wlk-Authorization") String accessToken, @Body UpdateUserPhoneReq req);

    /**
     * 批量异步同步部门信息
     * @param accessToken
     * @param req
     * @return
     */
    @POST("contact/v2/departments/bulk")
    SyncDepartmentsRes syncDepartments(@Header("x-wlk-Authorization") String accessToken, @Body SyncDeptReq req);

    /**
     * 批量异步删除部门信息
     * @param accessToken
     * @param req
     * @return
     */
    @POST("contact/v1/department/delete")
    Object delDepartment(@Header("x-wlk-Authorization") String accessToken, @Body DelDeptReq req);

    /**
     * 批量异步更新部门信息
     * @param accessToken
     * @param req
     * @return
     */
    @POST("contact/v2/departments/update")
    SyncDepartmentsRes updateDepartments(@Header("x-wlk-Authorization") String accessToken, @Body SyncDeptReq req);

    /**
     * 查询异步批量同步部门的结果。
     * @param accessToken
     * @param req
     * @return
     */
    @POST("contact/v2/departments/status")
    SyncDepartmentsRes syncDepartmentStatus(@Header("x-wlk-Authorization") String accessToken, @Body SyncDeptReq req);

    /**
     * 该接口用于企业应用中需要消息通知的场景。通过本接口，应用可以将信息推送给WeLink端用户。
     * @param accessToken
     * @param req
     * @return
     */
    @POST("messages/v3/send")
    Void sendOfficialAccountMsg(@Header("x-wlk-Authorization") String accessToken, @Body SendOfficialAccountMsgReq req);

}