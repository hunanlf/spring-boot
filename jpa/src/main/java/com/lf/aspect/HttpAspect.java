package com.lf.aspect;

import com.lf.auth.AopAnnotationTest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by liufeng on 2018/6/4
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.lf.web.JpaController.*(..))")
    //@Pointcut("execution(* com.lf.service..*(..))")
    public void log(){

    }

    @Pointcut("@within(aopAnnotationTest) || @annotation(aopAnnotationTest)")
    public void log2(AopAnnotationTest aopAnnotationTest){
        logger.warn("HttpAspect.log ############");
    }

    @Around("log2(aopAnnotationTest)")
    //@Around("log()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint,AopAnnotationTest aopAnnotationTest) {
        System.out.println("Around start..... 00000");
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("Around end  22222:" + result);
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    //@After("log()")
    public void after(){
        logger.warn("HttpAspect.after 222222222222222");
    }

    //@Before("log()")
    public void before(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

    }


}
