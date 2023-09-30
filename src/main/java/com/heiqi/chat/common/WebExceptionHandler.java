package com.heiqi.chat.common;

import com.heiqi.chat.Utils.AuthenticationException;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 统一异常处理
 * @author: libo
 */
@RestControllerAdvice
public class WebExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);


    /**
     * 校验失败
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Result validException(BindException e){
        log.error("校验失败", e);
        return Result.error(e.getBindingResult().getAllErrors().iterator().next().getDefaultMessage());
    }


    /**
     * 其它所有异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result unknownException(Exception e) {
        log.error("全局异常", e);
        return Result.error("全局异常");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public void httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e,
                                                       HttpServletResponse response){
        log.error("request method 不支持", e);
        response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());

    }

    @ExceptionHandler(AuthenticationException.class)
    public Result AuthenticationException(AuthenticationException e){
       return  Result.error(401, "请登录后操作");
    }
}