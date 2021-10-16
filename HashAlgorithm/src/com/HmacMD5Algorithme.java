/*
 * @Descripttion: 
 * @version: 
 * @@Company: QianFengJiaoYu JAVAEE-2103
 * @Author: SuspectCat
 * @Date: 2021-10-14 20:32:07
 * @LastEditors: SuspectCat
 * @LastEditTime: 2021-10-14 20:38:07
 * @name: SuspectCat
 * @test: test font
 * @msg: This file was be created by SuspectCat.
 * @param: 
 * @return: 
 */
package com;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class HmacMD5Algorithme {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, UnsupportedEncodingException {
        KeyGenerator HmacInstance = KeyGenerator.getInstance("HmacMD5");
        SecretKey generateKey = HmacInstance.generateKey();

        byte[] encoded = generateKey.getEncoded();

        System.out.println(new BigInteger(1, encoded).toString(16));

        Mac MacInstance = Mac.getInstance("HmacMD5");
        MacInstance.init(generateKey);
        MacInstance.update("Hello".getBytes("UTF-8"));
        byte[] doFinal = MacInstance.doFinal();

        System.out.println(new BigInteger(1, doFinal).toString(16));
    }
}