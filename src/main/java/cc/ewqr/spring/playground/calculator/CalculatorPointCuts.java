package cc.ewqr.spring.playground.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalculatorPointCuts {
    @Pointcut("execution(* *.*(..))")
    public void loggingOperation() {
    }

    @Pointcut("@annotation(cc.ewqr.spring.playground.calculator.LoggingRequired)")
    public void unitLoggingOperation() {
    }
}
