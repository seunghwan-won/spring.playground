package cc.ewqr.spring.playground.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("unitCalculator")
//@LoggingRequired
public class UniCalculatorImplement implements UnitCalculator {
    private static final Logger logger = LoggerFactory.getLogger(UniCalculatorImplement.class);

    @Override
    @LoggingRequired
    public double kilogramToPound(double kilogram) {
        double result = kilogram * 2.2;
        logger.debug(kilogram + " kilogram = " + result + " pound");
        return result;
    }

    @Override
//    @LoggingRequired
    public double kilometerToMile(double kilometer) {
        double result = kilometer * 0.62;
        logger.debug(kilometer + " kilometer = " + result + " mile");
        return result;
    }
}
