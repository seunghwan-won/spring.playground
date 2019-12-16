package cc.ewqr.spring.playground.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorValidationAspect implements Ordered {
      private static final Logger logger = LoggerFactory.getLogger(CalculatorValidationAspect.class);
    @Before("execution(* *.*(double, double))")
    public void validateBefore(JoinPoint joinpoint) {
        for(Object arg : joinpoint.getArgs())
            validate((Double) arg);
        logger.info("validation aspect");
    }

    private void validate(Double arg) {
        if(arg<0)
            throw new IllegalArgumentException("Positive number only");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
