package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;

/**
 * @author ：Wang
 * @date ：Created in 2020/8/4 14:05
 * @description：
 */
@Data
public class AttendanceException extends RuntimeException {

    public final static int SUCCESS_CODE = 0;
    public final static int FAIL_CODE = 1;

    private int  code;
    private String msg;

    public AttendanceException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }
    public AttendanceException(String codeString, String msg) {
        super(msg);
        this.msg = msg;
        this.code = Integer.parseInt(codeString);
    }
    public AttendanceException(String msg) {
        super(msg);
        this.msg = msg;
        this.code = FAIL_CODE;
    }
    public AttendanceException(IException iException) {
        super();
        this.msg = iException.getDesc();
        this.code = iException.getCode();
    }

    public AttendanceException(Throwable cause) {
        super(cause);
        this.code = FAIL_CODE;
    }
}
