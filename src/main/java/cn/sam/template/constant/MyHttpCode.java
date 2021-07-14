package cn.sam.template.constant;

public enum MyHttpCode {
    SUCCESS("20000"),
    SUCCESS_WITH_WARNING("20001"),
    FORBIDDEN("40000"),
    NOT_ALLOWED("40001"),
    SERVER_ERROR("50000"),
    PARAM_ERROR("30001"),
    NOT_FOUND("30002")
    ;

    private final String code;

    MyHttpCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
