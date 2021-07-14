package cn.sam.template.commons;


public class MyToken {

    public static String buildToken(String userId, String type) {
        return String.format("%s-%s-%s", type, userId, MyString.get6RandomChar());
    }

}
