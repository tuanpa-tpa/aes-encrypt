package com.example.encrypt.common;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private String code;
    private String description;
    private T data;

    public static <T> BaseResponse<T> success(T data) {
        return build(ResCode.SUCCESS, data);
    }

    public static BaseResponse success() {
        return success(null);
    }

    public static <T> BaseResponse<T> fail(BaseException ex, T data) {
        return build(ex.getResCode(), data);
    }

    public static BaseResponse fail(BaseException ex) {
        return build(ex.getResCode(), null);
    }


    public static <T> BaseResponse<T> internalError(T data) {
        return build(ResCode.INTERNAL_ERROR, data);
    }

    public static BaseResponse internalError() {
        return internalError(null);
    }

    /* Utils function for build base response*/
    private static <T> BaseResponse<T> build(String code, String description, T data) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setCode(code);
        response.setDescription(description);
        response.setData(data);
        return response;
    }
    private static <T> BaseResponse build(ResCode resCode, T data) {
        return build(resCode.getCode(), resCode.getDescription(), data);
    }

    private static BaseResponse build(ResCode resCode) {
        return build(resCode, null);
    }

    private static <T> BaseResponse<T> fail(ResCode resCode, T data) {
        return build(resCode, data);
    }

    private static BaseResponse fail(ResCode resCode) {
        return fail(resCode, null);
    }
}
