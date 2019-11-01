package com.exceptions;

import com.util.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 *
 * @author suyongming
 */
@RestControllerAdvice
public class CustomExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public ResultBean handleRRException(CustomException e){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(e.getCode());
        resultBean.setMsg(e.getMsg());
        return resultBean;
    }


    @ExceptionHandler(Exception.class)
    public ResultBean handleException(Exception e){
        logger.error(e.getMessage(), e);
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(500);
        resultBean.setMsg("Error");
        return resultBean;
    }
}