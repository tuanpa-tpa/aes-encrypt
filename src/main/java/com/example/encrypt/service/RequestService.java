package com.example.encrypt.service;

import com.example.encrypt.common.BaseException;
import com.example.encrypt.common.BaseRequest;
import com.example.encrypt.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class RequestService {

    @Value("${key.aes}")
    private String aesKey;

    @Value("${key.hmac}")
    private String hmacKey;

    public BaseRequest newRequest(String data) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return RequestUtils.newRequest(data, aesKey, hmacKey);
    }

    public String parseRequest(BaseRequest request) throws BaseException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return RequestUtils.parseRequest(request.getEncryptedData(), request.getMac(), aesKey, hmacKey);
    }
}
