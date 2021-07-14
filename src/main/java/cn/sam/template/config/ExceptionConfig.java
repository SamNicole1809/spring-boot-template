package cn.sam.template.config;

import cn.sam.template.execption.MyExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e) {
        return MyExceptionHandler.exceptionHandler(e);
    }

}
