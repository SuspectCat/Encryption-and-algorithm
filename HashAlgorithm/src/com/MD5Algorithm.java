/*
 * @Descripttion: 
 * @version: 
 * @@Company: QianFengJiaoYu JAVAEE-2103
 * @Author: SuspectCat
 * @Date: 2021-10-14 20:16:40
 * @LastEditors: SuspectCat
 * @LastEditTime: 2021-10-14 20:22:35
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

/**
 * MD5Algorithm
 */
public class MD5Algorithm {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        /* Greate an MessageDigest */
        MessageDigest md5Instance = MessageDigest.getInstance("MD5");
        /* using update to input data */
        md5Instance.update("Hello".getBytes("UTF-8"));
        md5Instance.update("word".getBytes("UTF-8"));

        byte[] result = md5Instance.digest();

        System.out.println(new BigInteger(1, result).toString(16));
    }
}