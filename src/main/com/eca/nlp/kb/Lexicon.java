package com.eca.nlp.kb;

import com.eca.nlp.kb.model.Number;
import com.eca.nlp.kb.model.Operator;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

public final class Lexicon {

    private static final Collection<Number> NUMBERS;
    private static final Collection<Operator> OPERATORS;
    public static final Number ZERO = new Number("0", "zero");
    public static final Number ONE = new Number("1", "one");
    public static final Number TWO = new Number("2", "two");
    public static final Number THREE = new Number("3", "three");
    public static final Number FOUR = new Number("4", "four");
    public static final Number FIVE = new Number("5", "five");
    public static final Number SIX = new Number("6", "six");
    public static final Number SEVEN = new Number("7", "seven");
    public static final Number EIGHT = new Number("8", "eight");
    public static final Number NINE = new Number("9", "nine");

    public static final Operator PLUS = new Operator("+", toSet("ADD", "PLUS"));
    public static final Operator MINUS = new Operator("-", toSet("SUBTRACT", "MINUS", "LESS"));
    public static final Operator MULTIPLY = new Operator("*", toSet("MULTIPLY-BY", "TIMES"));
    public static final Operator DIVIDE = new Operator("/", toSet("DIVIDE-BY", "OVER"));

    static {
        NUMBERS = of(
                ZERO,
                ONE,
                TWO,
                THREE,
                FOUR,
                FIVE,
                SIX,
                SEVEN,
                EIGHT,
                NINE
        ).collect(immutableCollector());

        OPERATORS = of(
                PLUS,
                MINUS,
                MULTIPLY,
                DIVIDE
        ).collect(immutableCollector());
    }

    private static <T> Collector<T, ?, List<T>> immutableCollector() {
        return collectingAndThen(toList(), Collections::unmodifiableList);
    }

    private static Set<String> toSet(String... humanOperator) {
        return of(humanOperator).collect(Collectors.toSet());
    }

    private Lexicon() {
        throw new UnsupportedOperationException();
    }

    public static Collection<Number> numbers() {
        return NUMBERS;
    }

    public static Collection<Operator> operators() {
        return OPERATORS;
    }
}
