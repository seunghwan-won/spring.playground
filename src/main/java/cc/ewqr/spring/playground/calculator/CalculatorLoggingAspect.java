package cc.ewqr.spring.playground.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorLoggingAspect.class);

    @Before("execution(* ArithmeticCalculator.add(..))")
    public void beforeLog() {
        logger.debug("The method add() begins");
    }
}
