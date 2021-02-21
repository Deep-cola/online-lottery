package com.cola.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @description: 自定义异常: 保存错误码和错误信息
 * @author: Deepcola
 * @time: 2021/1/29 19:35
 */
@Getter
@Setter
public class AppException extends RuntimeException {

    private String code;

    public AppException(String code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
