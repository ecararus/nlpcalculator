package com.eca.nlp.calculator.operation;

public class Divide implements ArithmeticEvaluator {

    @Override
    public Number evaluate(Number left, Number right) {
        if(right.equals(0)){
            throw new UnsupportedOperationException("Division by 0");
        }
        if (left instanceof Double || right instanceof Double) {
            return left.doubleValue() / right.doubleValue();
        } else {
            return (double)left.intValue() / right.intValue();
        }
    }
}
