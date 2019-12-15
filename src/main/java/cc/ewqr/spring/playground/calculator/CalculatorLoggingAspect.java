package cc.ewqr.spring.playground.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorLoggingAspect.class);

    @Before("execution(* ArithmeticCalculator.add(..))")
    public void beforeLog() {
        logger.info("The method add() begins");
    }

    @Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* *.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("The method " + joinPoint.getSignature().getName() + "() ends");
    }

    @AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("The method {}() ends with {}", joinPoint.getSignature().getName(), result);
    }

    @Around("execution(* *.*(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("The method {}() begins with {}", pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));

        try {
            Object result = pjp.proceed();
            logger.info("The method {}() ends with ", pjp.getSignature().getName(), result);
            return result;
        } catch (IllegalArgumentException e ) {
            logger.error("Illegal argument {} in {}()", Arrays.toString(pjp.getArgs()), pjp.getSignature().getName());
            throw e;
        }
    }

}
