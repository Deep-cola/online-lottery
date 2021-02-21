package com.cola.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @description: 自定义异常: 保存错误码以及错误信息
 * @author: Deepcola
 * @time: 2021/2/21 16:16
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
