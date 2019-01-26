package com.lf.aop.springbootaop.aspect;

import com.lf.aop.springbootaop.service.AopAnnotationTest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lf
 * @描述
 * @date 2018-10-09
 */
@Aspect
@Component
public class HttpAspect {

    @Pointcut("@within(aopAnnotationTest) || @annotation(aopAnnotationTest)")
    public void log2(AopAnnotationTest aopAnnotationTest){

    }

    @Around("log2(aopAnnotationTest)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, AopAnnotationTest aopAnnotationTest) {

        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();

        String authorization = request.getHeader("Authorization");
        System.out.println("authorization:     "+authorization);

        System.out.println("Around start..... 000000");
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("Around end  222222 :" + result);
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
