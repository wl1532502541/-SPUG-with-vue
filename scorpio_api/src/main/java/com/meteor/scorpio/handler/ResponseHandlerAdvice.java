package com.meteor.scorpio.handler;

import com.meteor.scorpio.handler.base.BaseResponse;
import com.meteor.scorpio.handler.base.ResponseCode;
import com.meteor.scorpio.handler.base.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一响应体处理器
 * @author MENGZEYUN
 * @date 2020-07-16
 */

/**
 * 类名：ResponseHandlerAdvice
 * 功能：统一响应处理器
 * 详细：
 * 修改日期：2020-09-06 00:38
 * 说明：
 **/
@ControllerAdvice(annotations = BaseResponse.class)
public class ResponseHandlerAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (MediaType.APPLICATION_JSON.equals(aClass)) {
            // 如果响应返回的对象为统一响应体，则直接返回body
            if (body instanceof ResponseResult) {
                return body;
            }else {
                // 只有正常返回的结果才会进入这个判断流程，所以返回正常成功的状态码
                ResponseResult responseResult = new ResponseResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(),body);
                return responseResult;
            }
        }
//         非JSON格式body直接返回即可
         return body;
//        ResponseResult responseResult = new ResponseResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(),body);
//        return responseResult;
    }
}

