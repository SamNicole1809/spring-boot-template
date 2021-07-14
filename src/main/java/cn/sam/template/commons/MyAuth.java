package cn.sam.template.commons;

import cn.sam.template.execption.MyServiceException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class MyAuth {

    public static String encodeMD5(String val) throws MyServiceException {
        try {
            return Base64.getEncoder().encodeToString(MessageDigest.getInstance("MD5").digest(val.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new MyServiceException();
        }
    }

}
