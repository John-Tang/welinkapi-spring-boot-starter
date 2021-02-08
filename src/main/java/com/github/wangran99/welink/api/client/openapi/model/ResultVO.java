package com.github.wangran99.welink.api.client.openapi.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

/**
 * 统一返回数据封装
 * @author wang
 */
public class ResultVO {
    public final static int SUCCESS_CODE = 0;
    public final static int FAIL_CODE = 1;
    public final static int AUTH_FAIL_OR_EXPIRED = 2; //认证失败或者认证已过期

    private int code;
    private String msg;

    private Object data;

    public ResultVO() {
    }

    public ResultVO(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVO getSuccess() {
        return new ResultVO(SUCCESS_CODE, "success");
    }

    public static ResultVO getSuccess(Object data) {
        ResultVO resultVO = new ResultVO(SUCCESS_CODE, "success",data);
        return resultVO;
    }

    public static ResultVO getSuccess(Object data, String msg) {
        ResultVO resultVO = new ResultVO(SUCCESS_CODE, msg,data);
        return resultVO;
    }


    public static ResultVO getAuthFailOrExpired(String errorMessage, String redirectUrl) {
        return new ResultVO(AUTH_FAIL_OR_EXPIRED, errorMessage, redirectUrl);
    }

    public static ResultVO getError() {
        return new ResultVO(FAIL_CODE, "request failed.");
    }

    public static ResultVO getError(String errorMessage) {
        return new ResultVO(FAIL_CODE, errorMessage);
    }

    public Object convertClass(Class clazz) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(data);
        return gson.fromJson(json, clazz);
    }

    public static ResultVO getError(int code, String errorMessage) {
        return new ResultVO(code, errorMessage);
    }

    public static ResultVO getError(IException e) {
        return new ResultVO(e.getCode(), e.getDesc());
    }

}
