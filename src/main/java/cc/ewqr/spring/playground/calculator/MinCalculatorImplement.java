package cc.ewqr.spring.playground.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("minCalculator")
public class MinCalculatorImplement implements MinCalculator {
    private static final Logger logger = LoggerFactory.getLogger(MinCalculatorImplement.class);

    @Override
    public double min(double a, double b) {
        double result = a < b ? a : b;
        logger.info("min( " + a + " , " + b + " ) = " + result);
        return result;
    }
}
