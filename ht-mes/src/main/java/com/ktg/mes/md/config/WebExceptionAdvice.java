package com.ktg.mes.md.config;

import com.ktg.common.core.domain.AjaxResult;
import com.ktg.mes.md.exception.IdExistNotException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

/**
 * @author zhstart_bytedance
 * @version 1.0
 * @date 2023/4/8 11:10
 * @description mes
 */
@RestControllerAdvice
@Slf4j
public class WebExceptionAdvice {
    @ExceptionHandler(IdExistNotException.class)
    public AjaxResult handleIdExistNotException(String msg) {
        return AjaxResult.error(msg);
    }

    @ExceptionHandler(RuntimeException.class)
    public AjaxResult handleRuntimeException(RuntimeException e) {
        return AjaxResult.error(e.getMessage());
    }
}
