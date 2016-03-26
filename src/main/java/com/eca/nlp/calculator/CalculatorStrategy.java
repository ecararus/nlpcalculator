package com.eca.nlp.calculator;

public final class CalculatorStrategy {

    private final Calculator calculator;

    public CalculatorStrategy(Calculator calculator) {
        this.calculator = calculator;
    }

    public <T> T calculate(String arithmeticalExpression) {
        //noinspection unchecked
        return (T) calculator.calculate(arithmeticalExpression);
    }
}
