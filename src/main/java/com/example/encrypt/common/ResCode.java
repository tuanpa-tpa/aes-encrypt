package com.example.encrypt.common;

public enum ResCode {

    SUCCESS("00", "SUCCESS"),
    INVALID_MAC("20", "INVALID_MAC"),
    INVALID_REQUEST("21", "INVALID_REQUEST"),
    INVALID_ENCRYPTED_DATA("22", "INVALID_ENCRYPTED_DATA"),

    INTERNAL_ERROR("99", "INTERNAL_ERROR");

    private String code;
    private String description;


    ResCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
