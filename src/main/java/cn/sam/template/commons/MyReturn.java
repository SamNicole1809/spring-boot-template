package cn.sam.template.commons;

import cn.sam.template.constant.MyHttpCode;
import com.alibaba.fastjson.JSON;

public class MyReturn implements Cloneable {

    private static final MyReturn instance = new MyReturn();

    public MyReturn clone() {
        try {
            return (MyReturn) super.clone();
        } catch (Exception e) {
            return new MyReturn();
        }
    }

    // 初始化方法
    public static MyReturn newMessage() {
        return instance.clone();
    }

    private String code;
    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static String forbidden() {
        return fullMessage(MyHttpCode.FORBIDDEN.getCode(), null, null);
    }

    public static String warning(String message) {
        return fullMessage(MyHttpCode.SUCCESS_WITH_WARNING.getCode(), message, null);
    }

    public static String error() {
        return fullMessage(MyHttpCode.SERVER_ERROR.getCode(), null, null);
    }

    public static String ok() {
        return ok(null);
    }

    public static String ok(String message) {
        return ok(message, null);
    }

    public static String ok(String message, Object data) {
        return fullMessage(MyHttpCode.SUCCESS.getCode(), message, data);
    }

    public static String ok(Object data) {
        return fullMessage(MyHttpCode.SUCCESS.getCode(), "OK", data);
    }

    // 完整方法
    public static String fullMessage(String code, String message, Object data) {
        MyReturn msg = instance.clone();
        msg.setCode(code);
        msg.setMessage(message);
        msg.setData(data);
        return JSON.toJSONString(msg);
    }

}
