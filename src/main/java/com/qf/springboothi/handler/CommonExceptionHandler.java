package com.qf.springboothi.handler;

import com.qf.springboothi.entity.ResultBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GuanYeFan
 * @Date 2019/6/4
 * 全局异常处理
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean exceptionHandler(Exception e){
        //当何种异常下响应何种异常信息
        return new ResultBean("400", "请稍后");
    }
}
