package com.github.wangran99.welink.api.client.timer;

import cn.hutool.core.bean.BeanUtil;
import com.github.wangran99.welink.api.client.openapi.api.WeLinkApiV2;
import com.github.wangran99.welink.api.client.openapi.model.AuthV2TicketsRequest;
import com.huawei.welink.api.accesstoken.AuthV2TicketsResponse;
import com.huawei.welink.api.tenant.TenantV1TenantsResponse;
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
    private WeLinkApiV2 weLinkApiV2;
    @Autowired
    private AuthV2TicketsRequest authV2TicketsRequest;
    @Autowired
    private AuthV2TicketsResponse authV2TicketsResponse;
    @Autowired
    private TenantV1TenantsResponse tenantV1TenantsResponse;

    /**
     * 每隔半小时鉴权一次
     */
    @Scheduled(fixedRate = 180000)
    public void scheduled() {
        log.info("==================>>>>>begin update token by auth timer<<<<<================");
        AuthV2TicketsResponse authResponse = weLinkApiV2.auth(authV2TicketsRequest);
        authV2TicketsResponse.setAccessToken(authResponse.getAccessToken());
        authV2TicketsResponse.setExpiresIn(authResponse.getExpiresIn());
        TenantV1TenantsResponse tenantInfoResponse  = weLinkApiV2.getTenantInfo();
        BeanUtils.copyProperties(tenantInfoResponse, tenantV1TenantsResponse);
        BeanUtil.setFieldValue(tenantV1TenantsResponse, "data", tenantInfoResponse.getData());
        log.info("===================>>>>>end update token by auth timer<<<<<=================");
    }

}
