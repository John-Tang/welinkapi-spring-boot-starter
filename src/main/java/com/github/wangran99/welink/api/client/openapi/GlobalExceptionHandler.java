package com.github.wangran99.welink.api.client.openapi;


import com.github.wangran99.welink.api.client.openapi.model.AttendanceException;
import com.github.wangran99.welink.api.client.openapi.model.AuthFailOrExpiredException;
import com.github.wangran99.welink.api.client.openapi.model.OpenApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：WangRan
 * @date ：Created in 2020/12/6 11:31
 * @description：全局异常管理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 一般Exception
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Exception handlerExceptionHello(Exception e) {
        log.error("exception" + e.getMessage(), e);
        return e;
    }

    /**
     * 参数合法性校验异常
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MethodArgumentNotValidException handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("参数校验异常-{}--{}", exception.getParameter(), exception.getMessage(), exception);
        return exception;
    }

    /**
     * 参数合法性校验异常-类型不匹配
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public MethodArgumentTypeMismatchException handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        log.error("参数校验异常--{}-{}", exception.getParameter(), exception.getMessage(), exception);
        return exception;
    }

    /**
     * 考勤系统通用异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = AttendanceException.class)
    public AttendanceException handlerAttendanceException(AttendanceException e) {
        log.error("AttendanceException: errCode:" + e.getCode() + ",msg:" + e.getMsg(), e);
        return e;
    }

    /**
     * 调用welink开放平台时出现的异常处理逻辑
     * @param e
     * @return
     */
    @ExceptionHandler(value = OpenApiException.class)
    public OpenApiException handlerOpenApiException(OpenApiException e) {
        log.error("OpenApiException: errCode:" + e.getCode() + ",msg:" + e.getMsg(), e);
        return e;
    }

    /**
     * 用户认证失败或者认证已过期的处理逻辑
     * @param e
     * @return
     */
    @ExceptionHandler(value = AuthFailOrExpiredException.class)
    public AuthFailOrExpiredException handlerAuthFailOrExpiredException(AuthFailOrExpiredException e) {
        log.error("AuthFailOrExpiredException: errCode:" + e.getCode() + ",msg:" + e.getMsg(), e);
        return e;
    }

    /**
     * 空指针异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public NullPointerException handlerNullPointerException(HttpServletRequest req, NullPointerException e) {
        log.error("发生空指针异常！原因是:", e);
        return e;
    }

}