package cn.sam.template.execption;

public class MySqlException extends Exception {
    public MySqlException() {
    }

    public MySqlException(String message) {
        super(message);
    }
}
