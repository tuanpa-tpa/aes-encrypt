package com.example.encrypt.crypto;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AES {

    public static final int IV_LENGTH = 16;
    private static final String ALGORITHM = "AES";
    private static final String AES_ALGORITHM_TYPE = "AES/CTR/NoPadding";


    public static byte[] generateIV() {
        byte[] iv = new byte[IV_LENGTH];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        return iv;
    }

    public static byte[] encrypt(String data, String key, byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM_TYPE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        return cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }

    public static String decrypt(byte[] data, String key, byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM_TYPE);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        return new String(cipher.doFinal(data), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String key = "UkXp2s5v8x/A?D(G+KbPeShVmYq3t6w9";
        String data = "Hello world";
        byte[] iv = generateIV();
        byte[] encryptedData = encrypt(data, key, iv);
        String rawData = decrypt(encryptedData, key, iv);
        System.out.println(rawData.equals(data));
    }
}
