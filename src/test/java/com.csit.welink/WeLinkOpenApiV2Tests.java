package com.csit.welink;

import com.github.wangran99.welink.api.client.ClientApplication;
import com.github.wangran99.welink.api.client.openapi.api.WeLinkApiV2;
import com.huawei.welink.api.tenant.TenantV1TenantsResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * insert comment here.
 *
 * @author johntang
 * @date 2022/08/29 13:53
 */
@SpringBootTest(classes = ClientApplication.class)
@Slf4j
public class WeLinkOpenApiV2Tests {

    @Resource
    protected WeLinkApiV2 api;

    @Resource
    protected TenantV1TenantsResponse tenantV1TenantsResponse;

    @Test
    public void main() throws InterruptedException {
        Thread.sleep(5000L);
        log.info("name = {}", tenantV1TenantsResponse.getData().getCompanyNameCn());
    }

}
