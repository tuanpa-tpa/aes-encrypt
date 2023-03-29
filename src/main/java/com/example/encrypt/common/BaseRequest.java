package com.example.encrypt.common;

import lombok.Data;

@Data
public class BaseRequest {
    private String encryptedData;
    private String mac;
}
