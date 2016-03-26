package com.eca.nlp.calculator.impl;

import com.eca.nlp.calculator.Calculator;

/**
 * Factory for different strategies.
 */
public final class CalculatorProvider {

    private CalculatorProvider() {
        throw new UnsupportedOperationException();
    }

    public static Calculator loadBasicCalculator(){
        return new BasicCalculator();
    }
}
