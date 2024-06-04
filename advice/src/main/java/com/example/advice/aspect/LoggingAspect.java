package com.example.advice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public void addJog())")
    public void forAddRun() {
        System.out.println("before Run.addJog()");
    }

    @Before("execution(* com.example.advice.Run.add*())")
    public void forRunAdd() {
        System.out.println("Before Run.add*");
    }

    @Before("execution(* add*(..))")
    public void forAdd() {
        System.out.println("Before add*");
    }

    @Pointcut("execution(* addMarathon(*))")
    private void forMarathon() {}

    @Before("forMarathon()")
    public void pointcutMarathon() {
        System.out.println("logger using pointcut declaration");
    }

    @Pointcut("execution(* com.example.advice.*.get*())")
    private void getAdvice() {}

    @Pointcut("execution(* com.example.advice.*.set*(*))")
    private void setAdvice() {}

    @Pointcut("getAdvice() || setAdvice()")
    private void getterOrSetter() {}

    @Before("getterOrSetter()")
    public void beforeGetterOrSetter(JoinPoint joinPoint) {
        System.out.println("Before getter or setter " + joinPoint.getSignature());
    }

    @AfterReturning(
            pointcut = "execution(* is*(*))",
            returning = "flag")
    private void joinDemo(JoinPoint joinPoint, boolean flag) {
        System.out.println("returned value is " + flag);
    }

    @Around("execution(* run*())")
    private void aroundDemo(ProceedingJoinPoint proceedingJoinPoint) {
        long startTime = Calendar.getInstance().get(Calendar.MILLISECOND);
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {

        }

        long endTime = Calendar.getInstance().get(Calendar.MILLISECOND);
        System.out.println(endTime - startTime);

    }
}
