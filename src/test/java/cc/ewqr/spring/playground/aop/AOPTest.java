package cc.ewqr.spring.playground.aop;

import cc.ewqr.spring.playground.calculator.ArithmeticCalculator;
import cc.ewqr.spring.playground.calculator.CalculatorConfiguration;
import cc.ewqr.spring.playground.calculator.UnitCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
    ArithmeticCalculator arithmeticCalculator;
    UnitCalculator unitCalculator;

    @BeforeEach
    void setUp() {
        arithmeticCalculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);
        unitCalculator = context.getBean("unitCalculator", UnitCalculator.class);
    }

    @Test
    void arithmeticCalculatorAddTest() {
        arithmeticCalculator.add(1, 1);
    }

    @Test
    void unitCalculatorKTPTest() {
        unitCalculator.kilogramToPound(100);
    }

    @Test
    void unitCalculatorKTMTest() {
        unitCalculator.kilometerToMile(10);
    }
}
