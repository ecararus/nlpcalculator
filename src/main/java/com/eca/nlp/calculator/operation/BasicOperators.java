package com.eca.nlp.calculator.operation;

import java.util.Collection;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public class BasicOperators {

    public static final Operator PLUS;
    public static final Operator MINUS;
    public static final Operator MULTIPLY;
    public static final Operator DIVIDE;
    private static final Collection<Operator> SUPPORTED_OPERATORS;

    static {
        PLUS = new Operator(0, "+", new Add());
        MINUS = new Operator(0, "-", new Subtract());
        MULTIPLY = new Operator(1, "*", new Multiply());
        DIVIDE = new Operator(1, "/", new Divide());
        SUPPORTED_OPERATORS = unmodifiableList(asList(PLUS, MINUS, MULTIPLY, DIVIDE));
    }

    private BasicOperators() {
        throw new UnsupportedOperationException();
    }

    public static boolean isOperator(String operator) {
        return SUPPORTED_OPERATORS.stream().anyMatch(o -> o.getType().equals(operator));
    }

    public static Operator fromString(String operator) {
        return SUPPORTED_OPERATORS.stream().filter(o -> o.getType().equals(operator)).findFirst().orElseThrow(() -> new UnsupportedOperationException(operator));
    }

}
