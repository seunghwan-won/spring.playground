package cc.ewqr.spring.playground.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImplement implements ArithmeticCalculator {
    private static final Logger logger = LoggerFactory.getLogger(ArithmeticCalculatorImplement.class);

    @Override
    public double add(double a, double b) {
        double result = a + b;
        logger.debug(a + " + " + b + " = " + result);
        return result;
    }

    @Override
    public double sub(double a, double b) {
        double result = a - b;
        logger.debug(a + " - " + b + " = " + result);
        return result;
    }

    @Override
    public double mul(double a, double b) {
        double result = a * b;
        logger.debug(a + " * " + b + " = " + result);
        return result;
    }

    @Override
    public double div(double a, double b) {
        double result = a / b;
        logger.debug(a + " / " + b + " = " + result);
        return result;
    }
}
