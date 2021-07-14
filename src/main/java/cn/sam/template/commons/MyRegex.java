package cn.sam.template.commons;


import java.util.regex.Pattern;

public class MyRegex {

    public static boolean isPassword(String val) {
        return matches("^[\\w!@#$%^&*]{6,16}$", val);
    }

    public static boolean isEmail(String val) {
        return matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", val) && val.length() <= 30;
    }

    public static boolean isUserName(String val) {
        return matches("^[\\u4E00-\\u9FA5\\da-zA-Z_]{6,16}$", val);
    }

    private static boolean matches(String regex, String val) {
        return !MyString.isNullOrEmpty(val) && Pattern.matches(regex, val);
    }

}
