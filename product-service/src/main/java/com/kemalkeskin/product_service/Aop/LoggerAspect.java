package com.kemalkeskin.product_service.Aop;

import com.kemalkeskin.product_service.core.exception.BusinessException;
import com.kemalkeskin.product_service.core.exception.ProblemDetails;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Aspect
@Component
public class LoggerAspect {

    private  Logger logger=Logger.getLogger(getClass().getName());



    @Pointcut("execution(* com.kemalkeskin.product_service.business.*.*(..))")
    private void serviceLayer(){
    }
    @Pointcut("execution(* com.kemalkeskin.product_service.repository.*.*(..))")
    private void repositoryLayer(){
    }
    @Pointcut("execution(* com.kemalkeskin.product_service.api.*.*(..))")
    private void controllerLayer(){
    }

    @Pointcut("serviceLayer() || repositoryLayer() || controllerLayer()")
    private void allLayer(){

    }

    @Before("allLayer()")
    public void beforeAspect(JoinPoint joinPoint) {

        String result = joinPoint.getSignature().toShortString();
        logger.info("User= "+getCurrentUsername());
        logger.info("Before Result= " + result);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args)
            System.out.println("argument: " + arg);

    }

    @AfterThrowing(pointcut = "allLayer()",throwing = "exception")
    public void throwingAspect(Exception exception){
        logger.info(exception.getMessage());

    }


    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName(); // username
        }

        return "anonymous";
    }


}
