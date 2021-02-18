package com.github.wangran99.welink.api.client.openapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TenantInfoRes {
    String tenantId;
    String companyNameCn;
    String companyNameEn;
    String companyContactName;
    int registeredNumbers;
    int tenantType;
    String companyDomainName;
    int companyScale;
    LocalDate licenseStartTime;
    LocalDate licenseEndTime;
    LocalDateTime creationTime;
    LocalDateTime lastUpdatedTime;
    String tenantLogo;
}
