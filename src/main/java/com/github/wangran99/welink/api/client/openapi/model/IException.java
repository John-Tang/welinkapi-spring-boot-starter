/*
 * File Name: com.huawei.cloud.common.exception.IException.java
 *
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */

package com.github.wangran99.welink.api.client.openapi.model;

/**
 * 错误码类型定义
 *
 * @author WANGran Create on 20121年1月2日
 */
public interface IException {

    int getCode();

    String getDesc();

}
