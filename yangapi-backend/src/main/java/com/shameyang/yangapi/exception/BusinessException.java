package com.shameyang.yangapi.exception;

import com.shameyang.yangapi.common.ErrorCode;
import lombok.Getter;

/**
 * @author ShameYang
 * @date 2024/8/22 16:15
 * @description 自定义异常
 */
@Getter
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}