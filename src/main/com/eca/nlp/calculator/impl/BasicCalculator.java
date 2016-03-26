package com.eca.nlp.calculator.impl;

import com.eca.nlp.calculator.Calculator;
import com.eca.nlp.calculator.operation.Operator;

import java.util.Stack;

import static com.eca.nlp.calculator.operation.BasicOperators.*;

/**
 * Implementation of (Shunting-yard/Dijkstra Two Stack) algorithm.
 * More details available: https://en.wikipedia.org/wiki/Shunting-yard_algorithm.
 */
final class BasicCalculator implements Calculator<String> {

    @SuppressWarnings("unchecked")
    public Number calculate(String expression) {
        Stack<Number> values = new Stack<>();
        Stack<Operator> operators = new Stack<>();
        evaluateOneSymbol(operators, values, expression);
        evaluateOperationStack(operators, values);
        return values.pop();
    }

    private void evaluateOneSymbol(Stack<Operator> operations, Stack<Number> values, String expression) {
        if (expression.isEmpty()) {
            return; //braking condition
        }
        String current = expression.substring(0, 1);
        if (isOperator(current)) {
            processOperator(operations, values, current);
        } else {
            processNumber(values, current);
        }
        evaluateOneSymbol(operations, values, expression.substring(1));
    }

    private void processOperator(Stack<Operator> operators, Stack<Number> values, String current) {
        Operator currentOperator = fromString(current);
        if (!operators.isEmpty() && currentOperator.lowerPriority(operators.lastElement())) {
            evaluateLastOperator(operators, values);
        }
        operators.push(currentOperator);
    }

    private void processNumber(Stack<Number> values, String number) {
        values.push(Integer.valueOf(number));
    }

    private void evaluateOperationStack(Stack<Operator> operators, Stack<Number> values) {
        if (operators.isEmpty()) {
            return; //braking condition
        }
        evaluateLastOperator(operators, values);
        evaluateOperationStack(operators, values);
    }

    private void evaluateLastOperator(Stack<Operator> operators, Stack<Number> values) {
        Operator op = operators.pop();
        Number right = values.pop();
        Number left = getLeftValue(operators, values);
        values.push(op.getArithmeticEvaluator().evaluate(left, right));
    }

    private Number getLeftValue(Stack<Operator> operators, Stack<Number> values) {
        Number left = values.pop();
        if (!operators.isEmpty() && MINUS.equals(operators.lastElement())) {
            left = left.doubleValue() * -1;
            operators.pop();
            operators.push(PLUS);
        }
        return left;
    }

}
