package com.bat.common.utils;

import java.util.UUID;

/**
 * format return value
 * 2020-05-23
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
