package cn.sam.template.config;

import cn.sam.template.annotation.MyPermission;
import cn.sam.template.commons.MyReturn;
import cn.sam.template.execption.MyForbiddenException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AopConfig {

    @Pointcut("@annotation(cn.sam.template.annotation.MyPermission)")
    private void permission() {}


    /**
     * you can get token from request
     * check user permissions which method sign with @permission annotation
     * if permission not pass
     * should return MyReturn.forbidden()
     */
    @Around("permission() && @annotation(myPermission)")
    public Object permissionHandler(ProceedingJoinPoint proceedingJoinPoint, MyPermission myPermission) throws Throwable {
        HttpServletRequest request = this.getRequest();
        // check user permission here
        System.out.println("Test Permission Check");
        return proceedingJoinPoint.proceed();
    }

    private HttpServletRequest getRequest() throws MyForbiddenException {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new MyForbiddenException();
        }
        return ((ServletRequestAttributes)requestAttributes).getRequest();
    }

}
