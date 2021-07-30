package com.fei.rank.application.common;


import org.springframework.util.DigestUtils;

public class MD5Util {
    /**
     * 加密当前账户的密码并返回加密密码
     */
    public static String entryptionPwd(String userPwd) {
        String pwd = DigestUtils.md5DigestAsHex(userPwd.getBytes());
        return pwd;
    }
}
