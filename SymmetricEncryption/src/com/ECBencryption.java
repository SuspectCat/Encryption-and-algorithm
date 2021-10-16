/*
 * @Descripttion: 
 * @version: 
 * @@Company: QianFengJiaoYu JAVAEE-2103
 * @Author: SuspectCat
 * @Date: 2021-10-14 21:02:59
 * @LastEditors: SuspectCat
 * @LastEditTime: 2021-10-14 21:20:53
 * @name: SuspectCat
 * @test: test font
 * @msg: This file was be created by SuspectCat.
 * @param: 
 * @return: 
 */
package com;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ECBencryption {
    
    public static void main(String[] args) {
        
    }

    /**
     * 加密
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encrypt(byte[] key, byte[] input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
        byte[] generateSeed = instanceStrong.generateSeed(16);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(generateSeed);
        instance.init(Cipher.DECRYPT_MODE, secretKeySpec ,ivParameterSpec);
        byte[] doFinal = instance.doFinal(input);

        return join(generateSeed, doFinal);
    }

    /**
     * 解密
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] decrypt(byte[] key, byte[] input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];

        System.arraycopy(input, 0, iv, 0, 16);
        System.arraycopy(input, 16, data, 0, data.length);

        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");

        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        instance.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        return instance.doFinal(data);
    }

    /**
     * 
     * @param byte1
     * @param byte2
     * @return
     */
    public static byte[] join(byte[] byte1, byte[] byte2) {
        byte[] result = new byte[byte1.length + byte2.length];

        System.arraycopy(byte1, 0, result, 0, byte1.length);
        System.arraycopy(byte2, 0, result, byte1.length, byte2.length);

        return result;
    }
}
