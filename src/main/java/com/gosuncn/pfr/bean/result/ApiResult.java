package com.gosuncn.pfr.bean.result;

import com.gosuncn.pfr.common.ResultCode;

import java.io.Serializable;

/**
 * 接口统一返回结果
 * Created by hwj on 2017/5/21.
 */
public class ApiResult<T> implements Serializable {
    private int code=-1;
    private String msg="";
    private T data;

    public ApiResult(int code, String msg, T data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    /**
     * 直接从枚举里取错信息
     * by ningjinxiang 2019.07.16
     * @param resultCode
     */
    public ApiResult(ResultCode resultCode){
        this.code=resultCode.getCode();
        this.msg=resultCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
