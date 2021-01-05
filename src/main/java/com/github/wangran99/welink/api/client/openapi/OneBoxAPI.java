package com.github.wangran99.welink.api.client.openapi;




import com.github.wangran99.welink.api.client.openapi.model.CreateFolerRes;
import com.github.wangran99.welink.api.client.openapi.model.OneBoxAuthRes;
import com.github.wangran99.welink.api.client.openapi.model.PreUploadRes;
import okhttp3.MultipartBody;
import retrofit2.http.*;

import java.util.Map;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/19 14:17
 * @description：云盘服务接口
 */
public interface OneBoxAPI {
    String ONEBOX_HEADER_FLAG = "ONE_BOX_FLAG:ONE_BOX_BASE_URL";

    @POST("/api/v2/sso/oneBox")
    @Headers({"Content-Type:application/json", ONEBOX_HEADER_FLAG})
    OneBoxAuthRes login(@Header("x-access-token") String token);

    @POST("/api/v2/folders/{cloudUserId}")
    @Headers({"Content-Type:application/json", ONEBOX_HEADER_FLAG})
    CreateFolerRes createFolder(@Header("Authorization") String token,
                                @Path("cloudUserId") long cloudUserId, @Body Map<String, Object> map);
    
    @PUT("/api/v2/files/{cloudUserId}")
    @Headers({"Content-Type:application/json", ONEBOX_HEADER_FLAG})
    PreUploadRes preUploadFile(@Header("Authorization") String token, @Path("cloudUserId") long cloudUserId,
                               @Body  Map<String, Object> map);

    @Multipart
    @PUT()
    @Headers({"Content-Type:application/octet-stream"})
    PreUploadRes uploadFile(@Part MultipartBody.Part body);

}
