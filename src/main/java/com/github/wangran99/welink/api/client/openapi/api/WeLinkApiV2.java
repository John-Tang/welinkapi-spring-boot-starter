package com.github.wangran99.welink.api.client.openapi.api;

import com.github.wangran99.welink.api.client.openapi.model.AuthV2TicketsRequest;
import com.huawei.welink.api.accesstoken.AuthV2TicketsResponse;
import com.huawei.welink.api.athenaservice.AthenaserviceV1ContextawarePushRequest;
import com.huawei.welink.api.athenaservice.AthenaserviceV1ContextawarePushResponse;
import com.huawei.welink.api.calendar.events.*;
import com.huawei.welink.api.contact.user.AuthV2UseridRequest;
import com.huawei.welink.api.contact.user.AuthV2UseridResponse;
import com.huawei.welink.api.contactnew.batch.*;
import com.huawei.welink.api.contactnew.department.*;
import com.huawei.welink.api.contactnew.role.*;
import com.huawei.welink.api.contactnew.user.*;
import com.huawei.welink.api.message.*;
import com.huawei.welink.api.tenant.TenantV1TenantsResponse;
import com.huawei.welink.api.todo.*;
import retrofit2.http.*;

/**
 * WeLink API封装
 *
 * @author johntang
 * @date 2022/08/29 09:37
 */
public interface WeLinkApiV2 {

    /**
     * 此接口用于We码小程序(或者H5轻应用)与WeLink服务端API后台集成，实现免登, 通讯录查询等接口。
     *
     * @param request
     * @return
     */
    @POST("auth/v2/tickets")
    @Headers({"Content-Type:application/json"})
    AuthV2TicketsResponse auth(@Body AuthV2TicketsRequest request);

    /**
     * 获取租户信息
     *
     * @param  （不同租户提供的accessToken是不同的）
     * @return
     */
    @GET("tenant/v1/tenants")
    @Headers({"Content-Type:application/json"})
    TenantV1TenantsResponse getTenantInfo();

    /**
     * 根据we码中获得authCode获取用户id和租户信息
     *
     * @param request    免登授权码
     * @return 用户id和租户id
     */
    @GET("auth/v2/userid")
    AuthV2UseridResponse getUserBasicIdInfo(AuthV2UseridRequest request);

    /**
     * 批量同步用户，在WeLink中同步用户信息，同步结果异步返回，支持批量创建和更新用户信息，
     * 如果用户不存在就创建用户、如果用户存在就更新用户信息，每次请求最多支持100个用户。
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/2vfify
     * @param request
     * @return
     */
    @POST("contact/v1/user/batch/sync")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1UserBatchSyncResponse syncUserBatch(@Body ContactV1UserBatchSyncRequest request);

    /**
     * 创建用户
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/f4piho
     * @param request
     * @return
     */
    @POST("contact/v1/user/create")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1UserCreateResponse createUser(@Body ContactV1UserCreateRequest request);

    /**
     * 批量创建用户,在WeLink中创建用户，创建结果异步返回，支持批量创建用户，每次请求最多支持100个用户。
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/gjhea2
     * @param request
     * @return
     */
    @POST("contact/v1/user/batch/create")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1UserBatchCreateResponse createUserBatch(@Body ContactV1UserBatchCreateRequest request);

    /**
     * 在WeLink中更新用户，更新结果实时返回。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/vopau3
     * @param request
     * @return
     */
    @POST("contact/v1/user/update")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1UserUpdateResponse updateUser(@Body ContactV1UserUpdateRequest request);

    /**
     * 批量更新用户
     * 在WeLink中更新用户，更新结果异步返回，支持批量更新用户信息，每次请求最多支持100个用户。
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/ojanqp
     * @param request
     * @return
     */
    @POST("contact/v1/user/batch/update")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1UserBatchUpdateResponse updateUserBatch(@Body ContactV1UserBatchUpdateRequest request);

    /**
     * 在WeLink中删除用户，删除结果实时返回。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/1mdou0
     * @param request
     * @return
     */
    @POST("contact/v1/user/delete")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1UserDeleteResponse deleteUser(@Body ContactV1UserDeleteRequest request);

    /**
     * 批量删除用户
     * 在WeLink中删除用户，删除结果异步返回，支持批量删除用户，每次请求最多支持100个用户。
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/e5kpsd
     * @param request
     * @return
     */
    @POST("contact/v1/user/batch/delete")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1UserBatchDeleteResponse deleteUserBatch(@Body ContactV1UserBatchDeleteRequest request);

    /**
     * 获取用户详细信息
     *
     * @param request
     * @return
     */
    @POST("contact/v2/user/detail")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1UserDetailResponse getUserDetailById(@Body ContactV1UserDetailRequest request);

    /**
     * 查询部门用户简单信息
     * 根据部门ID获取部门内所有用户简单信息（如用户id，用户中文名称，用户英文名称）列表，支持分页查询。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/lsaq2z
     *
     * @param request
     * @return
     */
    @GET("contact/v1/user/simplelist")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1UserSimplelistResponse getUserSimpleList(@QueryMap ContactV1UserSimplelistRequest request);

    /**
     * 查询部门用户详细信息
     * 根据部门ID获取部门内所有用户的详细信息列表，支持分页查询。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/cqsmjb
     * @param request
     * @return
     */
    @GET("contact/v2/user/list")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV2UserListResponse getUserDetailInfoByDepartment(@QueryMap ContactV2UserListRequest request);

    /**
     * 在WeLink中创建部门，创建结果实时返回。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/fwi6e7
     * @param request
     * @return
     */
    @POST("contact/v1/department/create")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1DepartmentCreateResponse createDepartment(@Body ContactV1DepartmentCreateRequest request);

    /**
     * 批量创建部门。在WeLink中创建部门，创建结果异步返回，支持批量创建部门，每次请求最多支持100个部门。
     * 此接口为异步接口，返回的信息仅表明参数是否合法，
     * 是否同步成功请访问《获取异步任务结果https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/ml9ac5》接口查询。
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/8hxds0
     * @param request
     * @return
     */
    @POST("contact/v2/department/batch/create")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV2DepartmentBatchCreateResponse createDepartmentBatch(@Body ContactV2DepartmentBatchCreateRequest request);

    /**
     * 在WeLink中更新部门，创建结果实时返回。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/ystdt7
     * @param request
     * @return
     */
    @POST("contact/v1/department/update")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1DepartmentUpdateResponse updateDepartment(@Body ContactV1DepartmentUpdateRequest request);

    /**
     * 批量更新部门。更新结果异步返回，支持批量更新部门，每次请求最多支持100个部门。
     * 此接口为异步接口，返回的信息仅表明参数是否合法，
     * 是否同步成功请访问《获取异步任务结果https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/ml9ac5》接口查询。
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/iqd944
     * @param request
     * @return
     */
    @POST("contact/v2/department/batch/update")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV2DepartmentBatchUpdateResponse updateDepartmentBatch(@Body ContactV2DepartmentBatchUpdateRequest request);

    /**
     * 批量同步部门。在WeLink中同步部门信息，同步结果异步返回，支持批量创建、更新、删除部门信息，如果部门不存在就创建部门信息；如果部门存在就更新角色组信息；如果部门状态是0就删除部门信息。每次请求最多支持100个部门。
     * 此接口为异步接口，返回的信息仅表明参数是否合法，
     * 是否同步成功请访问《获取异步任务结果https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/ml9ac5》接口查询。
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/iqd944
     * @param request
     * @return
     */
    @POST("contact/v1/department/batch/sync")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1DepartmentBatchSyncResponse syncDepartmentBatch(@Body ContactV1DepartmentBatchSyncRequest request);

    /**
     * 在WeLink中删除部门，删除结果实时返回。，使用客户部门corpDeptCode/WeLink部门deptCode删除部门。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/lmhpw0
     * @param request
     * @return
     */
    @POST("contact/v1/department/delete")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1DepartmentDeleteResponse deleteDepartment(@Body ContactV1DepartmentDeleteRequest request);

    /**
     * 批量删除部门，在WeLink中删除部门，删除结果异步返回，支持批量删除部门，每次请求最多支持100个部门。
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/vcbyal
     * @param request
     * @return
     */
    @POST("contact/v1/department/batch/delete")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1DepartmentBatchDeleteResponse deleteDepartmentBatch(@Body ContactV1DepartmentBatchDeleteRequest request);

    /**
     * 查询部门信息。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/lmhpw0
     * @param request
     * @return
     */
    @POST("contact/v2/department/detail")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV2DepartmentDetailResponse getDepartmentDetail(@Body ContactV2DepartmentDetailRequest request);

    /**
     * 查询部门列表。根据部门编码查询子部门信息。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/jtnvlg
     * @param request
     * @return
     */
    @POST("contact/v2/department/detail")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV2DepartmentListResponse getDepartmentList(@Body ContactV2DepartmentListRequest request);

    /**
     * 查询部门列表。根据部门编码查询子部门信息。调用通讯录接口能获取哪些部门和员工的数据是受通讯录权限范围控制的
     * https://open.welink.huaweicloud.com/docs/#/990hh0/whokyc/jtnvlg
     * @param request
     * @return
     */
    @POST("contact/v2/department/detail")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV2DepartmentParentResponse getDepartmentParentList(@Body ContactV2DepartmentParentRequest request);

    /**
     * 在WeLink中创建角色组，创建结果实时返回。最大只支持20个角色组。
     * @param request
     * @return
     */
    @POST("contact/v1/rolegroup/create")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RolegroupCreateResponse createRoleGroup(@Body ContactV1RolegroupCreateRequest request);

    /**
     * 在WeLink中更新角色组，更新结果实时返回。
     * @param request
     * @return
     */
    @POST("contact/v1/rolegroup/update")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RolegroupUpdateResponse updateRoleGroup(@Body ContactV1RolegroupUpdateRequest request);

    /**
     * 在WeLink中删除角色组，删除结果实时返回。
     * @param request
     * @return
     */
    @POST("contact/v1/rolegroup/delete")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RolegroupDeleteResponse deleteRoleGroup(@Body ContactV1RolegroupDeleteRequest request);

    /**
     * 请求角色组详细信息的接口，获取角色组详细数据。
     * @param request
     * @return
     */
    @POST("contact/v1/rolegroup/detail")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RolegroupDetailResponse getRoleGroupDetail(@Body ContactV1RolegroupDetailRequest request);

    /**
     * 遍历出所有的角色组信息，最大20个角色组。
     * @param request
     * @return
     */
    @POST("contact/v1/rolegroup/simplelist")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RolegroupSimplelistResponse getRoleGroupSimpleList(@Body ContactV1RolegroupSimplelistRequest request);

    /**
     * 根据角色组查询下面所有的角色列表信息。
     * @param request
     * @return
     */
    @POST("contact/v1/rolegroup/list")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RolegroupListResponse getRoleList(@Body ContactV1RolegroupListRequest request);

    /**
     * 在WeLink中创建角色，创建结果实时返回。
     * @param request
     * @return
     */
    @POST("contact/v1/role/create")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RoleCreateResponse createRole(@Body ContactV1RoleCreateRequest request);

    /**
     * 在WeLink中更新角色，更新结果实时返回。
     * @param request
     * @return
     */
    @POST("contact/v1/role/update")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RoleUpdateResponse updateRole(@Body ContactV1RoleUpdateRequest request);

    /**
     * 在WeLink中删除角色，删除结果实时返回。
     * @param request
     * @return
     */
    @POST("contact/v1/role/delete")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RoleDeleteResponse deleteRole(@Body ContactV1RoleDeleteRequest request);

    /**
     * 请求角色详细信息的接口，获取角色详细数据。
     * @param request
     * @return
     */
    @POST("contact/v1/role/detail")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RoleDetailResponse getRoleDetail(@Body ContactV1RoleDetailRequest request);

    /**
     * 根据角色ID获取角色内所有用户简单信息（如用户id，用户中文名称，用户英文名称）列表，支持分页查询。
     * @param request
     * @return
     */
    @POST("contact/v1/role/simplelist")
    @Headers({"Accept-Charset: UTF-8", "Content-Type: application/json", "lang: zh"})
    ContactV1RoleSimplelistResponse getRoleUserList(@Body ContactV1RoleSimplelistRequest request);

    /**
     * 该接口用于向通知中心发送普通卡片通知。
     * @param request
     * @return
     */
    @POST("messages/v2/card/common")
    @Headers({"Content-Type: application/json"})
    MessagesV2CardCommonResponse sendCardCommonMessage(@Body MessagesV2CardCommonRequest request);

    /**
     * 该接口用于应用向通知中心发送卡片消息。
     * @param request
     * @return
     */
    @POST("messages/v1/card/wecode")
    @Headers({"Content-Type: application/json"})
    MessagesV1CardWecodeResponse sendCardWeCodeMessage(@Body MessagesV1CardWecodeRequest request);

    /**
     * 该接口用于向通知中心发送图片。
     * @param request
     * @return
     */
    @POST("messages/v1/card/wecode")
    @Headers({"Content-Type: application/json"})
    MessagesV1ImageResponse sendImageMessage(@Body MessagesV1ImageRequest request);

    /**
     * 该接口用于向通知中心发送图文消息。支持单图文、多图文。
     * @param request
     * @return
     */
    @POST("messages/v1/news")
    @Headers({"Content-Type: application/json"})
    MessagesV1NewsResponse sendNews(@Body MessagesV1NewsRequest request);

    /**
     * 该接口用于修改文本卡片消息，应用卡片消息的消息状态。
     * @param request
     * @return
     */
    @POST("messages/v1/update")
    @Headers({"Content-Type: application/json"})
    MessagesV1UpdateResponse updateMessage(@Body MessagesV1UpdateRequest request);

    /**
     * 该接口用于撤回公众号消息。
     * 仅支持文本卡片消息接口，应用卡片消息接口 ，图片消息接口，图文消息接口四个接口的消息撤回。
     * @param request
     * @return
     */
    @POST("messages/v1/recall")
    @Headers({"Content-Type: application/json"})
    MessagesV1RecallResponse recallMessage(@Body MessagesV1RecallRequest request);

    /**
     * 本接口发起小微立即推送，实现信息上传下达。适用于生日祝福、员工关怀、业务异常预警、监控运维等场景。
     * 小微推送属于强提醒，为避免造成用户困扰，当前每个企业每天只允许调用此接口100次。
     * @param request
     * @return
     */
    @POST("athenaservice/v1/contextaware/push")
    @Headers({"Content-Type: application/json"})
    AthenaserviceV1ContextawarePushResponse athenaPush(@Body AthenaserviceV1ContextawarePushRequest request);

    /**
     * 用于集成WeLink待办，在待办模块展示用户待处理的任务事项入口和用户发起的申请单入口。
     * @param request
     * @return
     */
    @POST("todo/v3/addtask")
    @Headers({"Content-Type: application/json"})
    TodoV3AddTaskResponse createTask(@Body TodoV3AddTaskRequest request);

    /**
     * 用于集成WeLink待办，当电子流的某一个人完成了其审批任务，调用此接口，将待办任务变更到下一个审批人。
     * @param request
     * @return
     */
    @POST("todo/v2/updatetask")
    TodoV2UpdatetaskResponse updateTask(@Body TodoV2UpdatetaskRequest request);

    /**
     * 当某个电子流发生撤销或者整个电子流所有环节都完成后，调用此接口。
     * @param request
     * @return
     */
    @POST("todo/v1/deltask")
    TodoV1DeltaskResponse deleteTask(@Body TodoV1DeltaskRequest request);

    /**
     * 接受事件日历信息，为用户新增WeLink事件日历信息。
     * 该接口用于企业应用中需要预定共同事件日历的场景。通过本接口，应用可以将信息推送给WeLink端用户。
     * @param request
     * @return
     */
    @POST("calendar/v1/events/add")
    CalendarV1EventsAddResponse createCalendarEvent(@Body CalendarV1EventsAddRequest request);

    /**
     * 接受事件日历信息和待更新事件Id，同步更新事件日历信息。
     * 该接口用于企业应用中需要更新事件日历的场景。通过本接口，应用可以将更新后的事件日历信息推送给WeLink端用户。
     * @param request
     * @return
     */
    @POST("calendar/v1/events/update")
    CalendarV1EventsUpdateResponse updateCalendarEvent(@Body CalendarV1EventsUpdateRequest request);

    /**
     * 接受事件日历唯一识别字串和接收者UserId信息，删除用户事件日历信息。
     * 该接口用于企业应用中需要删除事件日历的场景。
     * @param request
     * @return
     */
    @POST("calendar/v1/events/delete")
    CalendarV1EventsDeleteResponse deleteCalendarEvent(@Body CalendarV1EventsDeleteRequest request);


}
