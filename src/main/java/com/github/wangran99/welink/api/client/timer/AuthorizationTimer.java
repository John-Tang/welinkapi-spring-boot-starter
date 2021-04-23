package com.github.wangran99.welink.api.client.timer;


import com.github.wangran99.welink.api.client.openapi.OpenAPI;
import com.github.wangran99.welink.api.client.openapi.model.AuthReq;
import com.github.wangran99.welink.api.client.openapi.model.AuthRes;
import com.github.wangran99.welink.api.client.openapi.model.TenantInfoRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时器自动更新welink的token
 * @author ：WangRan
 */
@Slf4j
public class AuthorizationTimer {
    @Autowired
    private OpenAPI openAPI;
    @Autowired
    private AuthReq authReq;
    @Autowired
    private AuthRes authRes;
    @Autowired
    private TenantInfoRes tenantInfoRes;

    //每隔半小时鉴权一次
    @Scheduled(fixedRateString = "1800000")
    public void scheduled() {
        log.info("==================>>>>>begin update token by auth timer<<<<<================");
        AuthRes authResponse = openAPI.auth(authReq);
        authRes.setAccess_token(authResponse.getAccess_token());
        authRes.setExpires_in(authResponse.getExpires_in());
        TenantInfoRes tenantInfoResponse  = openAPI.getTenantInfo();
        BeanUtils.copyProperties(tenantInfoResponse,tenantInfoRes);
//        openAPI.jsAuth("asd");
        log.info("===================>>>>>end update token by auth timer<<<<<=================");
    }

}
