package com.cola.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description: 实现前后端格式统一的
 * @author: Deepcola
 * @time: 2021/2/21 16:12
 */
@Getter
@Setter
@ToString
public class JSONResponse {

    private boolean success;

    private String code;

    private String message;

    private Object data;
}
