package com.eca.nlp.calculator.operation;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class Operator{

    private final int priority;
    private final String type;
    private final ArithmeticEvaluator arithmeticEvaluator;

    public Operator(int priority, String type, ArithmeticEvaluator arithmeticEvaluator) {
        requireNonNull(type);
        requireNonNull(arithmeticEvaluator);
        this.priority = priority;
        this.type = type;
        this.arithmeticEvaluator = arithmeticEvaluator;
    }

    public int getPriority() {
        return priority;
    }

    public String getType() {
        return type;
    }

    public ArithmeticEvaluator getArithmeticEvaluator() {
        return arithmeticEvaluator;
    }

    public boolean lowerPriority(Operator o) {
        return this.priority < o.priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operator operator = (Operator) o;

        if (getPriority() != operator.getPriority()) return false;
        return getType().equals(operator.getType());
    }

    @Override
    public int hashCode() {
        int result = getPriority();
        result = 31 * result + getType().hashCode();
        return result;
    }

}
