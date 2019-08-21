package com.gosuncn.pfr.common;


/**
 *     4       04      1010
 *  错误类型 服务资源 细分错误码
 * ```
 *
 * 具体定义如下:
 *
 * #### 错误类型
 *
 * 错误类型定义该请求错误责权, 其中:
 *
 * - 1~3 为保留码, 一般不使用
 * - 4 用户权限错误, 使用于非法访问, 用户鉴权失败, 用户访问权限受限等
 * - 5 参数错误, 适用于参数错误, 参数缺省等
 * - 6 资源错误, 适用于访问资源不存在, 资源无法访问, 资源修改操作错误等
 * - 7 服务器错误, 适用于服务器内部错误等
 * - 8~9 占位码, 留待业务扩展使用
 */
public enum ResultCode {


    SUCCESS(0, "成功"),
    FAILED(-1, "失败"),
    UNKNOWN_ERROR(7040000, "未知错误"),
    INVALID_ACCESS(4040000, "非法访问"),
    NON_PARAMTER(5040000, "参数错误"),
    DATA_IS_NULL(6040000, "数据不存在"),


    //业务错误码
    COMPANY_IS_NULL(6040001, "找不到该旅店数据"),
    PERSON_IS_NULL(6040002, "该旅店找不到该入住人员"),
    DEVICE_DEAL_FAIL(6041001, "设备端请求处理失败"),

    
      ;


    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;

    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
