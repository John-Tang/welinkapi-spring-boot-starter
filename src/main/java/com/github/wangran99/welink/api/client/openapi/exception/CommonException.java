package com.github.wangran99.welink.api.client.openapi.exception;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/12/4 14:05
 * @description：
 */
@Data
public class CommonException extends RuntimeException {

    public final static int SUCCESS_CODE = 0;
    public final static int FAIL_CODE = 1;

    private int  code;
    private String msg;

    public CommonException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }
    public CommonException(String codeString, String msg) {
        super(msg);
        this.msg = msg;
        this.code = Integer.parseInt(codeString);
    }
    public CommonException(String msg) {
        super(msg);
        this.msg = msg;
        this.code = FAIL_CODE;
    }
    public CommonException(IException iException) {
        super(iException.getDesc());
        this.msg = iException.getDesc();
        this.code = iException.getCode();
    }

    public CommonException(Throwable cause) {
        super(cause);
        this.code = FAIL_CODE;
    }
}
