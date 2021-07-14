package cn.sam.template.execption;

public class MyServiceException extends Exception {
    public MyServiceException() {
    }

    public MyServiceException(String message) {
        super(message);
    }
}
