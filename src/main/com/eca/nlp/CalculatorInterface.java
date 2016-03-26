package com.eca.nlp;


import com.eca.nlp.calculator.Calculator;
import com.eca.nlp.calculator.CalculatorStrategy;

import java.text.DecimalFormat;

import static com.eca.nlp.calculator.impl.CalculatorProvider.loadBasicCalculator;
import static com.eca.nlp.kb.LexicalConverter.toArithmeticalExpression;

public final class CalculatorInterface {

    private CalculatorInterface() {
        throw new UnsupportedOperationException();
    }

    public static String calculate(String expression) {
        Calculator calculator = loadBasicCalculator();
        CalculatorStrategy strategy = new CalculatorStrategy(calculator);
        Object result = strategy.calculate(toArithmeticalExpression(expression));
        return new DecimalFormat("#.##").format(result);
    }

}
