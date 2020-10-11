package org.truebird.aop;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j
@Component
public class LogAdvice {

    // 접근제한자 클래스.메소드
    @Before( "execution(* org.truebird.service.SampleService*.*(..))")
    public void logBefore() {
        log.info("===================");
    }

    @Before( "execution(* org.truebird.service.SampleService*.doAdd(String,String)) && args(str1, str2)")
    public void logBeforeWithParam(String str1, String str2) {
        log.info("str1: " + str1);
        log.info("str2: " + str2);
    }

    @AfterThrowing(pointcut = "execution( * org.truebird.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        log.info("Exception.....!!!!");
        log.info("exception: " + exception);
    }

    // 직접 메소드를 실행할 수 있는 권한을 가지며 메소드의 전후 처리 가능
    @Around("execution(* org.truebird.service.SampleService*.*(..))") // 대상이 되는 타켓이나 파라미터 파악, 실행 결정
    public Object logTime(ProceedingJoinPoint pjp) { // void가 아닌 메소드의 실행 결과를 반환
        long start = System.currentTimeMillis();

        log.info("Target: " + pjp.getTarget().toString());
        log.info("Param: " + Arrays.toString(pjp.getArgs()));

        // invoke method
        Object result = null;

        try {
            result = pjp.proceed(); // 직접 실행
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        log.info("TIME: " + (end - start));
        return result;
    }

}
