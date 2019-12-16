package cc.ewqr.spring.playground.calculator;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorIntroduction {
    @DeclareParents(
            value = "cc.ewqr.spring.playground.calculator.ArithmeticCalculatorImplement",
            defaultImpl = MaxCalculatorImplement.class
    )
    public MaxCalculator maxCalculator;

    @DeclareParents(
            value = "cc.ewqr.spring.playground.calculator.ArithmeticCalculatorImplement",
            defaultImpl = MinCalculatorImplement.class
    )
    public MinCalculator minCalculator;

    @DeclareParents(
            value = "cc.ewqr.spring.playground.calculator.*CalculatorImplement",
            defaultImpl = CountImplement.class
    )
    public Counter counter;
}
