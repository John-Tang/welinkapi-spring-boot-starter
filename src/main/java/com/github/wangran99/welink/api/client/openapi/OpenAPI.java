package com.github.wangran99.welink.api.client.openapi;

import com.github.wangran99.welink.api.client.openapi.model.*;
import retrofit2.http.*;

import java.util.List;


/**
 * welink开放平台接口（https://open.welink.huaweicloud.com/docs）
 */
public interface OpenAPI {

    /**
     * welink开放平台鉴权，获取token。A租户的token不能用户获取B租户的各种信息，如人员，部门等
     *
     * @param authReq 不同租户的传递的租户id是不同的，得到的token也是不同
     * @return
     */
    @POST("auth/v2/tickets")
    @Headers({"Content-Type:application/json"})
    AuthRes auth(@Body AuthReq authReq);

    /**
     * 获取租户信息
     *
     * @param  （不同租户提供的accessToken是不同的）
     * @return
     */
    @GET("tenant/v1/tenants")
    @Headers({"Content-Type:application/json"})
    TenantInfoRes getTenantInfo();

    /**
     * 根据we码中获得authCode获取用户id和租户信息
     *
     * @param authCode    免登授权码
     * @return 用户id和租户id
     */
    @GET("auth/v2/userid")
    UserIdInfo getUserBasicIdInfo( @Query("code") String authCode);

    /**
     * 轻应用鉴权
     *
     * @param accessToken
     * @return
     */
    @GET("auth/v1/jstickets")
    JsticketsRes jsAuth(@Header("x-wlk-Authorization") String accessToken);


    /**
     * 根据用户ID获取详细信息
     *
     * @param userId
     * @return
     */
    @POST("contact/v1/user/detail")
    UserBasicInfoRes getUserInfoById( @Query("userId") String userId);

    /**
     * 根据用户手机号获取详细信息
     *
     * @param mobileNumber
     * @return
     */
    @POST("contact/v1/user/detail")
    UserBasicInfoRes getUserInfoByMobileNumber( @Query("mobileNumber") String mobileNumber);

    /**
     * 根据用户员工号获取详细信息
     *
     * @param corpUserId
     * @return
     */
    @POST("contact/v1/user/detail")
    UserBasicInfoRes getUserInfoByCorpUserId( @Query("corpUserId") String corpUserId);

    /**
     * 获取部门详情
     *
     * @param deptCode
     * @return
     */
    @GET("contact/v1/departments/{deptCode}")
    DeptDetailRes getDeptDetail( @Path("deptCode") String deptCode);

    /**
     * 获取用户角色和权限
     *
     * @param userId
     * @return
     */
    @GET("weopen/v1/isadmin")
    IsAdminRes isAdminAndRoles(@Query("userId") String userId);

    /**
     * 添加待办事项
     *
     * @param addTodoTaskReq
     * @return
     */
    @POST("todo/v1/addtask")
    AddTodoTaskRes addTodoTask( @Body AddTodoTaskReq addTodoTaskReq);

    /**
     * 最新版本添加待办事项
     *
     * @param addTodoTaskReq
     * @return
     */
    @POST("todo/v3/addtask")
    AddTodoTaskRes addTodoTasknew( @Body AddTodoTaskReq addTodoTaskReq);

    /**
     * 删除待办
     *
     * @param taskId
     * @return
     */
    @DELETE("todo/v1/deltask")
    Void delTodoTask(@Query("taskId") String taskId);

    /**
     * 获取子部门信息
     *
     * @param deptCode
     * @param recursiveflag 是否递归查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GET("contact/v1/departments/list")
    QueryDepartmentInfoResPage getSubDept( @Query("deptCode") String deptCode, @Query("recursiveflag") int recursiveflag, @Query("pageNo") int pageNo, @Query("pageSize") int pageSize);

    /**
     * 获取部门人员列表
     *
     * @param deptCode
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GET("contact/v1/user/list")
    QueryUserInfoResPage getUsersByDeptCode( @Query("deptCode") String deptCode, @Query("pageNo") String pageNum, @Query("pageSize") String pageSize);

    /**
     * 获取考勤打卡信息
     *
     * @param req
     * @return
     */
    @POST("attendance/v2/records")
    QueryPunchCardResPage getPunchCardByCorpId(@Body QueryPunchCardReq req);

    /**
     * 批量异步同步人员信息
     *
     * @param req
     * @return
     */
    @POST("contact/v2/users/bulk")
    List<SyncUserResItem> syncUsers( @Body SyncUsersReq req);

    /**
     * 批量异步更新人员信息
     *
     * @param req
     * @return
     */
    @PUT("contact/v2/users/update")
    List<SyncUserResItem> updateUsers( @Body SyncUsersReq req);

    /**
     * 查询异步批量同步用户的结果
     *
     * @param req
     * @return
     */
    @POST("contact/v1/users/status")
    List<SyncUserResItem> syncUserStatus( @Body SyncUsersReq req);

    /**
     * 修改用户绑定手机号，此接口实时返回修改结果。
     * 同一个已开户状态用户24小时之内只允许修改手机号3次，未开户状态用户无限制。
     *
     * @param req
     * @return
     */
    @PUT("contact/v1/user/mobilenumber")
    Void updateUserPhone( @Body UpdateUserPhoneReq req);

    /**
     * 批量异步同步部门信息
     *
     * @param req
     * @return
     */
    @POST("contact/v2/departments/bulk")
    List<SyncDeptResItem> syncDepartments( @Body SyncDeptReq req);

    /**
     * 批量异步删除部门信息
     *
     * @param req
     * @return
     */
    @POST("contact/v1/department/delete")
    Object delDepartment(@Body DelDeptReq req);

    /**
     * 批量异步更新部门信息
     *
     * @param req
     * @return
     */
    @POST("contact/v2/departments/update")
    List<SyncDeptResItem> updateDepartments( @Body SyncDeptReq req);

    /**
     * 查询异步批量同步部门的结果。
     *
     * @param req
     * @return
     */
    @POST("contact/v2/departments/status")
    List<SyncDeptResItem> syncDepartmentStatus( @Body SyncDeptReq req);

    /**
     * 该接口用于企业应用中需要消息通知的场景。通过本接口，应用可以将信息推送给WeLink端用户。
     *
     * @param req
     * @return
     */
    @POST("messages/v3/send")
    Void sendOfficialAccountMsg(@Body SendOfficialAccountMsgReq req);

}