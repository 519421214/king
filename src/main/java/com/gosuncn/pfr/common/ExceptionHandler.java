package com.gosuncn.pfr.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonParseException;
import com.gosuncn.pfr.bean.result.ApiResult;
import com.gosuncn.pfr.utils.Log;
import com.gosuncn.pfr.utils.business.ApiResultUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * 异常处理器，捕获所有异常，并按照统一格式返回
 * Created by hwj on 2017/5/21.
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResult<String> handle(HttpServletRequest request, Exception e )  {
        ApiResult<String> result = null;
        //是否要打印错误日志
        boolean isPrintLog = true;
        //入参校验 org.springframework.web.client.ResourceAccessException: I/O error on POST request for "http://null:80/v1/MEGBOX/faceGroups": null; nested exception is java.net.UnknownHostException: null
        if(e instanceof BindException){
            isPrintLog = false;
            BindingResult bindingResult = ((BindException) e).getBindingResult();
            result = ApiResultUtils.error(-1,bindingResult.getFieldError().getDefaultMessage());
        }else if(e instanceof HttpRequestMethodNotSupportedException || e.getCause() instanceof HttpRequestMethodNotSupportedException){
            isPrintLog = false;
            result = ApiResultUtils.error(-1,"请求方式(Get/Post)错误");
        }else if(e.getCause() instanceof JsonParseException){
            isPrintLog = false;
            result = ApiResultUtils.error(-1,"入参JSON格式错误");
        }else if(e instanceof MissingServletRequestParameterException){
            result = ApiResultUtils.error(-1,"缺少参数");
        }else if(e instanceof MethodArgumentTypeMismatchException){
            result = ApiResultUtils.error(-1,"参数类型错误");
        }else if(e instanceof EmptyResultDataAccessException){
            ApiResultUtils.error(-1,"数据库不存在此记录");
        }else if(e instanceof DataIntegrityViolationException){
            result = ApiResultUtils.error(-1,"违反数据库完整性，请检查字段");
        }else if (e instanceof MethodArgumentNotValidException) {//使用@Valid产生的异常
            result = ApiResultUtils.failed(((MethodArgumentNotValidException)e).getBindingResult().getAllErrors().get(0).getDefaultMessage());//请求参数验证不通过异常
            //result = ApiResultUtils.failed(e.getMessage());//请求参数验证不通过异常
        }else if (e instanceof ConstraintViolationException) {//使用@Validated产生的异常
            result = ApiResultUtils.failed(e.getMessage());//请求参数验证不通过异常
        }else if(e instanceof HttpMediaTypeNotSupportedException){
            result = ApiResultUtils.failed("请求Content-Type错误");
        }else if(e instanceof ResourceAccessException){
            isPrintLog = false;
            result = ApiResultUtils.error(-1, "远程端接口访问失败");
        }else if(e instanceof BusinessException){
            isPrintLog = false;
            result = ApiResultUtils.error(((BusinessException)e).getCode(), e.getMessage());
        }else {
            result = ApiResultUtils.error(-1, "未知错误");
        }
        if (isPrintLog){
            e.printStackTrace();
            Log.error("系统异常:" + e.getClass());
        }
        Log.info("response : {} ", JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue));
        return result;
    }
}
