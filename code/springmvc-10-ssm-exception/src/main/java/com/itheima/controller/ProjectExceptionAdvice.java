package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//@Controller + @ResponseBody + ...
public class ProjectExceptionAdvice {

    @ExceptionHandler({SystemException.class})
    public Result doSystemException(SystemException e) {
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        //记录日志
        //发消息给运维
        //发送右键给开发人员
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(Exception.class)//拦截所有异常Exception.class
    public Result doException(Exception exception) {//拦截到的异常会作为参数
        System.out.println("处理所有异常");
        return new Result(Code.SYSTEM_UNKNOWN_ERR, null, "出未知异常了");//可以返回前端一些数据
    }
    //其他层的异常怎么抛到这里集中处理?
    //  可能出错的地方抛出来,然后这里集中拦截处理
    //返回给前端消息
}
