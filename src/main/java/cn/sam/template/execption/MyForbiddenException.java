package cn.sam.template.execption;

public class MyForbiddenException extends Exception {
    public MyForbiddenException() {
    }

    public MyForbiddenException(String message) {
        super(message);
    }
}
