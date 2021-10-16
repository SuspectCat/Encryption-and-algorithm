/*
 * @Descripttion: 
 * @version: 
 * @@Company: QianFengJiaoYu JAVAEE-2103
 * @Author: SuspectCat
 * @Date: 2021-10-14 20:03:16
 * @LastEditors: SuspectCat
 * @LastEditTime: 2021-10-14 20:06:30
 * @name: SuspectCat
 * @test: test font
 * @msg: This file was be created by SuspectCat.
 * @param: 
 * @return: 
 */
package com;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Encoding {
    public static void main(String[] args) {
        /* Encoding URL */
        String encoded = URLEncoder.encode("中文", StandardCharsets.UTF_8);

        System.out.println(encoded);

        /* Decoding URL */
        String origin = URLDecoder.decode(encoded, StandardCharsets.UTF_8);

        System.out.println(origin);
    }
}
