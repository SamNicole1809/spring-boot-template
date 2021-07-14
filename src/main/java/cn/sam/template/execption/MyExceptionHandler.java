package cn.sam.template.execption;


import cn.sam.template.commons.MyReturn;

public class MyExceptionHandler {

    public static String exceptionHandler(Exception e) {
        if (e instanceof MyNotFoundException) {
            if (e.getMessage() != null) {
                return MyReturn.warning(e.getMessage());
            }
            return MyReturn.warning("Not Found");
        }
        if (e instanceof MyFormatException) {
            if (e.getMessage() != null) {
                return MyReturn.warning(e.getMessage());
            }
            return MyReturn.warning("Format Error");
        }
        if (e instanceof MyExistedException) {
            if (e.getMessage() != null) {
                return MyReturn.warning(e.getMessage());
            }
            return MyReturn.warning("Data Existed");
        }
        if (e instanceof MyParamException) {
            return MyReturn.warning("Param Error");
        }
        if (e instanceof MyNormalException) {
            return MyReturn.warning(e.getMessage());
        }
        if (e instanceof MySqlException) {
            return MyReturn.error();
        }
        if (e instanceof MyServiceException) {
            return MyReturn.error();
        }
        if (e instanceof MyForbiddenException) {
            return MyReturn.forbidden();
        }
        e.printStackTrace();
        return MyReturn.error();
    }

}
