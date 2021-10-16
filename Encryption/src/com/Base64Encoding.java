/*
 * @Descripttion: 
 * @version: 
 * @@Company: QianFengJiaoYu JAVAEE-2103
 * @Author: SuspectCat
 * @Date: 2021-10-14 20:07:23
 * @LastEditors: SuspectCat
 * @LastEditTime: 2021-10-14 20:12:15
 * @name: SuspectCat
 * @test: test font
 * @msg: This file was be created by SuspectCat.
 * @param: 
 * @return: 
 */
package com;

import java.util.Arrays;
import java.util.Base64;

public class Base64Encoding {
    
    public static void main(String[] args) {
        byte[] input = new byte[] {
            (byte)0xe4, (byte)0xb8, (byte)0xad
        };

        String base64Encoding = Base64.getEncoder().encodeToString(input);

        System.out.println(base64Encoding);

        byte[] decode = Base64.getDecoder().decode(base64Encoding);
        // System.out.println(decode.toString());
        System.out.println(Arrays.toString(decode));
    }
}
