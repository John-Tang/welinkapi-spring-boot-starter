# welinkapi-spring-boot-starter

### Welink开放平台接口springboot-starter

[Welink开放平台服务端](https://open.welink.huaweicloud.com/docs/) 接口调用封装
# 使用方法
在springboot项目的application.properties中添加welink We码或者轻应用的clientId和clientSecretKey。

```properties
# clientId
welink.openapi.client-id=20201231090249131354656
# clientSecretKey
welink.openapi.client-secret=a19af76f-23fdf-43fe-fd32-fdf54gf54

```
在代码中注入自动生成的AuthRes对象和OpenAPI对象。
```java
@Autowired
private OpenAPI openAPI;
@Autowired
private AuthRes authRes;

void test(){
    //获取租户信息
    TenantInfoRes   tenantInfoRes = openAPI.getTenantInfo(authRes.getAccess_token());
}
```
更多接口封装在openAPI类中。