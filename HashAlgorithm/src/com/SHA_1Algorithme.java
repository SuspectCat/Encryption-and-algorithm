/*
 * @Descripttion: 
 * @version: 
 * @@Company: QianFengJiaoYu JAVAEE-2103
 * @Author: SuspectCat
 * @Date: 2021-10-14 20:24:28
 * @LastEditors: SuspectCat
 * @LastEditTime: 2021-10-14 20:29:52
 * @name: SuspectCat
 * @test: test font
 * @msg: This file was be created by SuspectCat.
 * @param: 
 * @return: 
 */
package com;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_1Algorithme {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest SHA_1Instance = MessageDigest.getInstance("SHA-1");
        SHA_1Instance.update("Hello".getBytes("UTF-8"));
        SHA_1Instance.update("word".getBytes("UTF-8"));

        byte[] SHA_1Digest = SHA_1Instance.digest();

        System.out.println(new BigInteger(1, SHA_1Digest).toString(16));
    }
}
