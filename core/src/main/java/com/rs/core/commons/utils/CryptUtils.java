package com.rs.core.commons.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * Author: Oleh Osyka
 * Date: 4/21/2016
 * Time: 6:20 PM
 */
public final class CryptUtils {

    private static final String SALT = "CHISW";

    private CryptUtils() {
    }

    public static String md5(String raw) {
        return md5(raw, SALT);
    }

    public static String md5(String raw, String salt) {
        byte[] bytes = DigestUtils.md5((raw + salt).getBytes());
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
