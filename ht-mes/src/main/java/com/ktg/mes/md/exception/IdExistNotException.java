package com.ktg.mes.md.exception;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/8 11:07
 * @description mes
 */
public class IdExistNotException extends RuntimeException{
    static final long serialVersionUID = -338751699312422948L;

    public IdExistNotException() {
    }

    public IdExistNotException(String msg) {
        super(msg);
    }
}
