package com.eca.nlp.calculator.operation;

public class Add implements ArithmeticEvaluator {

    @Override
    public Number evaluate(Number left, Number right) {
        if (left instanceof Double || right instanceof Double) {
            return left.doubleValue() + right.doubleValue();
        } else {
            return left.intValue() + right.intValue();
        }
    }
}
