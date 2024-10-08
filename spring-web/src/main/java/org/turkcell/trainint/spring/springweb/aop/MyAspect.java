package org.turkcell.trainint.spring.springweb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Aspect
//@Component
public class MyAspect {

    private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);

    @Pointcut("execution(* org.turkcell.trainint.spring.springweb.aop.MyObject.*(..)) && args(xyz)")
    public void helloInterceptor(String xyz) {
    }

    @Before(value = "helloInterceptor(xyz)")
    public void beforeMethod(JoinPoint joinPointParam,
                             String xyz) {
        System.out.println("+++++++++++++ [Before] MyObject methodu çağrılıyor. Parametre : "
                           + xyz
                           + " JointPoint : "
                           + joinPointParam);
    }

    @After("helloInterceptor(xyz)")
    public void afterMethod(String xyz) {
        System.out.println("+++++++++++++ [After] MyObject methodu çağrıldı. Girdi : " + xyz);
    }

    @AfterReturning(value = "helloInterceptor(xyz)", returning = "retVal")
    public void afterReturningMethod(String xyz,
                                     String retVal) {
        System.out.println("+++++++++++++ [AfterReturning] MyObject methodu çağrıldı. Girdi : "
                           + xyz
                           + " result : "
                           + retVal);
    }

    @AfterThrowing(value = "helloInterceptor(xyz)", throwing = "exp")
    public void afterReturningMethod(String xyz,
                                     Exception exp) {
        System.out.println("+++++++++++++ MyObject methodu çağrıldı. Girdi : " + xyz + " exception : " + exp);
    }

    @Around(value = "helloInterceptor(xyz)")
    public Object beforeMethod(ProceedingJoinPoint joinPointParam,
                               String xyz) throws Throwable {
        try {

            Object[] argsLoc = joinPointParam.getArgs();

            Object[] newArgsLoc = new Object[1];
            newArgsLoc[0] = argsLoc[0] + " [param intercept]";
            long   delta      = System.nanoTime();
            Object proceedLoc = joinPointParam.proceed(newArgsLoc);
            System.out.println("'''''''''''''''''''Delta : " + (System.nanoTime() - delta));

            if (proceedLoc instanceof String) {
                String str = (String) proceedLoc;
                return str + " (return intercept)";
            }
//            logger.debug("JoinPoint  : " + joinPointParam);
//
//            logger.debug("JoinPoint  : {}", joinPointParam);
//
//            if (logger.isDebugEnabled()) {
//                logger.debug("JoinPoint  : " + joinPointParam);
//            }

            if (logger.isInfoEnabled()) {
                logger.info("[MyAspect][beforeMethod]-> Point Cut Around : "
                            + joinPointParam
                            + " retObj : "
                            + proceedLoc);
            }

            return proceedLoc;
        } catch (Throwable exp) {
            logger.error("[MyAspect][beforeMethod]-> *Error* : " + exp.getMessage(),
                         exp);
            throw exp;
        }

    }

    @Around(value = "@annotation(methodLogParam)")
    public Object beforeMethod(ProceedingJoinPoint joinPointParam,
                               MethodLog methodLogParam) throws Throwable {

        try {

            Object[] argsLoc = joinPointParam.getArgs();
            String methodCallLog = "Calling "
                                   + joinPointParam.toShortString()
                                   + " parameters : "
                                   + Arrays.toString(argsLoc);
            switch (methodLogParam.logLevel()) {
                case INFO -> {
                    if (logger.isInfoEnabled()) {
                        logger.info("[MyAspect][beforeMethod]-> " + methodLogParam.prefix() + " - " + methodCallLog);
                    }

                }
                case DEBUG -> {
                    if (logger.isDebugEnabled()) {
                        logger.debug("[MyAspect][beforeMethod]-> " + methodLogParam.prefix() + " - " + methodCallLog);
                    }
                }
                case ERROR -> {
                    logger.error("[MyAspect][beforeMethod]-> " + methodLogParam.prefix() + " - " + methodCallLog);
                }
            }
            long   delta      = System.nanoTime();
            Object proceedLoc = joinPointParam.proceed();
            String methodReturnLog = "Return from "
                                     + joinPointParam.toShortString()
                                     + " result : "
                                     + proceedLoc + (methodLogParam.methodTime() ? " method time : "
                                                                                   + (System.nanoTime() - delta) : "");
            switch (methodLogParam.logLevel()) {
                case INFO -> {
                    if (logger.isInfoEnabled()) {
                        logger.info("[MyAspect][beforeMethod]-> " + methodLogParam.prefix() + " - " + methodReturnLog);
                    }

                }
                case DEBUG -> {
                    if (logger.isDebugEnabled()) {
                        logger.debug("[MyAspect][beforeMethod]-> " + methodLogParam.prefix() + " - " + methodReturnLog);
                    }
                }
                case ERROR -> {
                    logger.error("[MyAspect][beforeMethod]-> " + methodLogParam.prefix() + " - " + methodReturnLog);
                }
            }

            return proceedLoc;
        } catch (Throwable exp) {
            logger.error("[MyAspect][beforeMethod]-> *Error* : " + exp.getMessage(),
                         exp);
            throw exp;
        }
    }

}
