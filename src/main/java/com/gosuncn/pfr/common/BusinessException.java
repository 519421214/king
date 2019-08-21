package com.gosuncn.pfr.common;

/**
 * 实际业务异常
 * spring 对RuntimeException才有事务回滚
 * Created by HWJ on 2017/3/19.
 */
public class BusinessException extends RuntimeException {
    private  int code = -1;

    public BusinessException(ResultCode code, String message) {
        super(message);
        this.code = code.getCode();
    }
    public BusinessException(ResultCode code) {
        super(code.getMessage());
        this.code = code.getCode();
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
