package com.example.encrypt.crypto;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacSHA512 {
    private static final String ALGORITHM = "HMACSHA512";

    public static String generateMac(byte[] data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(ALGORITHM);
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        mac.init(secretKey);
        byte[] macValue = mac.doFinal(data);
        return Base64.getEncoder().encodeToString(macValue);
    }

    public static String generateMac(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        return generateMac(data.getBytes(StandardCharsets.UTF_8), key);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String data = "Hello World";
        System.out.println(generateMac(data, "Hellooooo"));
    }
}
