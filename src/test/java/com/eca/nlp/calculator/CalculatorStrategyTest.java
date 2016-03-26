package com.eca.nlp.calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorStrategyTest {

    private String captor = "By default value is missing.";

    @Test
    public void calculate() throws Exception {
        Calculator calculatorMock = prepareCalculatorMock();
        String result = new CalculatorStrategy(calculatorMock).calculate("MyExpression");
        assertEquals("MyExpression",captor);
        assertEquals("Success",result);
    }

    private Calculator prepareCalculatorMock() {
        return new Calculator() {
            @Override
            public Object calculate(Object expression) {
                captor = expression.toString();
                return "Success";
            }
        };
    }
}