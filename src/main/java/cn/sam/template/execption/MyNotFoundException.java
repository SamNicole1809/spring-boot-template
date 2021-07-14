package cn.sam.template.execption;

public class MyNotFoundException extends Exception {
    public MyNotFoundException() {
    }

    public MyNotFoundException(String message) {
        super(message);
    }
}
