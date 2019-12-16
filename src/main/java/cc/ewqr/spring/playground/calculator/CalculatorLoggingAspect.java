package cc.ewqr.spring.playground.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorLoggingAspect implements Ordered {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorLoggingAspect.class);

    @Before("cc.ewqr.spring.playground.calculator.CalculatorPointCuts.unitLoggingOperation()")
    private void logJoinPoint(JoinPoint joinPoint) {
        logger.info("The method add() begins");
        logger.info("Join point kind : {}", joinPoint.getKind());
        logger.info("Signature declaring type : {}", joinPoint.getSignature().getDeclaringTypeName());
        logger.info("Signature name : {}", joinPoint.getSignature().getName());
        logger.info("Arguments : {}", joinPoint.getArgs());
        logger.info("Target class : {}", joinPoint.getTarget().getClass().getName());
        logger.info("This class : {}", joinPoint.getThis().getClass().getName());

    }

    @After("cc.ewqr.spring.playground.calculator.CalculatorPointCuts.unitLoggingOperation()")
    private void logAfter(JoinPoint joinPoint) {
        logger.info("The method " + joinPoint.getSignature().getName() + "() ends");
    }

    @AfterReturning(pointcut = "cc.ewqr.spring.playground.calculator.CalculatorPointCuts.unitLoggingOperation()", returning = "result")
    private void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("The method {}() ends with {}", joinPoint.getSignature().getName(), result);
    }

    @Around("cc.ewqr.spring.playground.calculator.CalculatorPointCuts.unitLoggingOperation()")
    private Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("The method {}() begins with {}", pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));

        try {
            Object result = pjp.proceed();
            logger.info("The method {}() ends with ", pjp.getSignature().getName(), result);
            return result;
        } catch (IllegalArgumentException e) {
            logger.error("Illegal argument {} in {}()", Arrays.toString(pjp.getArgs()), pjp.getSignature().getName());
            throw e;
        }
    }

    @Before("cc.ewqr.spring.playground.calculator.CalculatorPointCuts.unitLoggingOperation()")
    private void unitLog(JoinPoint joinPoint) {
        logger.info("ZzzzzzzZ");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
