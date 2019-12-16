package cc.ewqr.spring.playground.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("maxCalculator")
public class MaxCalculatorImplement implements MaxCalculator {
    private static final Logger logger = LoggerFactory.getLogger(MaxCalculatorImplement.class);

    @Override
    public double max(double a, double b) {
        double result = a > b ? a : b;
        logger.info("max( " + a + " , " + b + " ) = " + result);
        return result;
    }
}
