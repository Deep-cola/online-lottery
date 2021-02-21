package com.cola.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/1/29 19:34
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
