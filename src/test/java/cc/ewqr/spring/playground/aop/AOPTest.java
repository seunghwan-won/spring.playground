package cc.ewqr.spring.playground.aop;

import cc.ewqr.spring.playground.calculator.ArithmeticCalculator;
import cc.ewqr.spring.playground.calculator.CalculatorConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    @Test
    void beforeAdd() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
        ArithmeticCalculator calculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);
        calculator.add(1, 1);
    }
}
