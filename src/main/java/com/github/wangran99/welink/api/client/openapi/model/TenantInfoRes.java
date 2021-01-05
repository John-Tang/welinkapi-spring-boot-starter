package com.github.wangran99.welink.api.client.openapi.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TenantInfoRes {
    String tenantId;
    String companyNameCn;
    String companyNameEn;
    String companyContactName;
    int registeredNumbers;
    int tenantType;
    String companyDomainName;
    int companyScale;
    LocalDateTime licenseStartTime;
    LocalDateTime licenseEndTime;
    LocalDateTime creationTime;
    LocalDateTime lastUpdatedTime;
    String tenantLogo;
}
