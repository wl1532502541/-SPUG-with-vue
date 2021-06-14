package com.meteor.scorpio.handler;

import com.meteor.scorpio.handler.base.BaseException;
import com.meteor.scorpio.handler.base.BaseResponse;
import com.meteor.scorpio.handler.base.ResponseCode;
import com.meteor.scorpio.handler.base.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类名：ExceptionHandlerAdvice
 * 功能：统一异常处理器
 * 详细：注意这个统一异常处理器只对认证过的用户调用接口中的异常有作用，对AuthenticationException没有用
 * 修改日期：2020-09-06 00:38
 * 说明：
 **/
@ControllerAdvice(annotations = BaseResponse.class)
@ResponseBody
public class ExceptionHandlerAdvice {

    /**
     * 处理未捕获的Exception
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handlerRuntimeException (RuntimeException e) {
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(),ResponseCode.SERVICE_ERROR.getMsg(),null);
    }

    /**
     * 处理未捕获的RuntimeException
     * @param e 运行时异常
     * @return 统一响应体
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException e){
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(),ResponseCode.SERVICE_ERROR.getMsg(),null);
    }

    /**
     * 处理业务异常BaseException
     * @param e 业务异常
     * @return 统一响应体
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult handleBaseException(BaseException e){
        ResponseCode code= e.getCode();
        return new ResponseResult(code.getCode(),code.getMsg(),null);
    }



}
