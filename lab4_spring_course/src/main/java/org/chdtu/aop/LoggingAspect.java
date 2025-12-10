package org.chdtu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* org.chdtu..*(..))")
    public void allMethodsInPackage() {}

    @Pointcut("execution(* org.chdtu.Person.*(..))")
    public void personMethods() {}

    @Pointcut("execution(* *.say*(..))")
    public void sayMethods() {}

    @Before("allMethodsInPackage()")
    public void logBeforeMethod(JoinPoint jp) {
        System.out.println("BEFORE → Виконується метод: " + jp.getSignature());
        System.out.println("   Аргументи: " + Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(pointcut = "personMethods()", returning = "result")
    public void logAfterPersonMethod(JoinPoint jp, Object result) {
        System.out.println("AFTER RETURNING → Метод " + jp.getSignature() + " завершився");
        if (result != null) {
            System.out.println("   Повернув: " + result);
        }
    }

    @Around("sayMethods()")
    public Object logAroundSay(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("AROUND → Собака/кішка збирається гавкати/нявкати...");
        long start = System.nanoTime();

        Object result = pjp.proceed();

        long time = System.nanoTime() - start;
        System.out.println("AROUND → Метод " + pjp.getSignature() + " виконався за " + time / 1_000_000 + " мс");
        return result;
    }

    @After("execution(* org.chdtu..*.*(..)) && within(@org.springframework.stereotype.Component *)")
    public void logBeanCreation(JoinPoint jp) {
        System.out.println("NEW BEAN → Створено бін: " + jp.getTarget().getClass().getSimpleName());
    }
}