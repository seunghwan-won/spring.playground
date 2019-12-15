package cc.ewqr.spring.playground.calculator;

import org.slf4j.Logger;

public interface ArithmeticCalculator {
    double add(double a, double b);

    double sub(double a, double b);

    double mul(double a, double b);

    double div(double a, double b);
}
