package com.example.encrypt.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends Exception{

    private final ResCode resCode;

    public BaseException(ResCode resCode) {
        this.resCode = resCode;
    }

    public ResCode getResCode() {
        return this.resCode;
    }
}
