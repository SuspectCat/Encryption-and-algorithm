/*
 * @Descripttion: 
 * @version: 
 * @@Company: QianFengJiaoYu JAVAEE-2103
 * @Author: SuspectCat
 * @Date: 2021-10-14 20:45:16
 * @LastEditors: SuspectCat
 * @LastEditTime: 2021-10-14 21:01:37
 * @name: SuspectCat
 * @test: test font
 * @msg: This file was be created by SuspectCat.
 * @param: 
 * @return: 
 */
package com;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * AESencryption
 */
public class AESencryption {

    public static void main(String[] args) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        /* Origin */
        String message = "Hello word";
        System.out.println("Origin >> " + message);

        byte[] bytes = "1234567890abcdef".getBytes("UTF-8");
        byte[] messageData = message.getBytes("UTF-8");

        byte[] encodingMessage = encodingMessage(bytes, messageData);

        System.out.println("encoding >> " + Base64.getEncoder().encodeToString(encodingMessage));

        byte[] decodingMessages = decodingMessages(bytes, encodingMessage);

        System.out.println("decoding << " + new String(decodingMessages, "UTF-8"));
        // System.out.println(Base64.getDecoder().decode(decodingMessages));
    }

    /**
     * encoding
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encodingMessage(byte[] key, byte[] message) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        instance.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        return instance.doFinal(message);
    }

    /** 
     * decoding
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] decodingMessages(byte[] key, byte[] input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

        instance.init(Cipher.DECRYPT_MODE, secretKeySpec);

        return instance.doFinal(input);
    }
}