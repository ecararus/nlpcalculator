package com.eca.nlp.calculator.operation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static com.eca.nlp.calculator.operation.BasicOperators.fromString;
import static com.eca.nlp.calculator.operation.BasicOperators.isOperator;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BasicOperatorsTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void not_instantiable() throws Exception {
        thrown.expectCause(instanceOf(UnsupportedOperationException.class));
        Constructor<BasicOperators> constructor = BasicOperators.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void should_be_operator() throws Exception {
        assertTrue(isOperator("+"));
    }

    @Test
    public void should_not_be_operator() throws Exception {
        assertFalse(isOperator("%"));
    }

    @Test
    public void unknown_operation() throws Exception {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("%");
        fromString("%");
    }

    @Test
    public void should_find_plus_operator() throws Exception {
        assertEquals(new Operator(0, "+", new Add()), fromString("+"));
    }

    @Test
    public void should_find_minus_operator() throws Exception {
        assertTrue(new Operator(0, "-", new Subtract()).equals(fromString("-")));
    }

    @Test
    public void should_find_multiply_operator() throws Exception {
        assertEquals(new Operator(1, "*", new Multiply()), fromString("*"));
    }

    @Test
    public void should_find_divide_operator() throws Exception {
        assertEquals(new Operator(1, "/", new Divide()), fromString("/"));
    }
}