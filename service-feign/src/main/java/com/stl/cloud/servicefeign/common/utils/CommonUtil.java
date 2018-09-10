package com.stl.cloud.servicefeign.common.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class CommonUtil {
    public static void main(String[] args) {
        String password = "12345646496674646416464646791633791646999791";
        String cryptResult = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(cryptResult);
        System.out.println(BCrypt.checkpw(password, cryptResult));
    }
}
