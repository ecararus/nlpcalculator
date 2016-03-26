package com.eca.nlp.calculator.operation;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTest {

    @Test(expected = NullPointerException.class)
    public void should_not_allow_intantiation_with_null_type() throws Exception {
        new Operator(0, null, new Add());
    }

    @Test(expected = NullPointerException.class)
    public void should_not_allow_intantiation_with_null_evaluator() throws Exception {
        new Operator(0, "+", null);
    }

    @Test
    public void multiply_has_more_priority_vs_plus() throws Exception {
        Operator add = new Operator(0, "+", new Add());
        Operator multiply = new Operator(1, "*", new Multiply());
        assertTrue(add.lowerPriority(multiply));
        assertFalse(multiply.lowerPriority(add));
    }
    @Test
    public void same_instance_should_be_equal() throws Exception {
        Operator add = new Operator(0, "+", new Add());
        assertTrue(add.equals(add));
    }

    @Test
    public void could_not_be_equal_with_null() throws Exception {
        Operator add = new Operator(0, "+", new Add());
        assertFalse(add.equals(null));
    }

    @Test
    public void could_not_be_equal_with_different_instance() throws Exception {
        Operator add = new Operator(0, "+", new Add());
        assertFalse(add.equals(new String()));
    }

    @Test
    public void could_not_be_equal_when_priority_is_different() throws Exception {
        Operator add = new Operator(0, "+", new Add());
        Operator multiply = new Operator(1, "+", new Add());
        assertFalse(add.equals(multiply));
    }

    @Test
    public void could_not_be_equal_when_Type_is_different() throws Exception {
        Operator add = new Operator(1, "+", new Add());
        Operator multiply = new Operator(1, "*", new Add());
        assertFalse(add.equals(multiply));
    }

    @Test
    public void should_be_equal_when_evaluator_is_different() throws Exception {
        Operator add = new Operator(1, "+", new Add());
        Operator multiply = new Operator(1, "+", new Multiply());
        assertTrue(add.equals(multiply));
    }

    @Test
    public void should_be_equal_when_params_is_the_same() throws Exception {
        Operator add = new Operator(1, "+", new Add());
        Operator plus = new Operator(1, "+", new Add());
        assertTrue(add.equals(plus));
    }

    @Test
    public void hashcode_should_Be_Consistent() {
        Operator add = new Operator(1, "+", new Add());
        int initialHashcode = add.hashCode();
        assertEquals(initialHashcode, add.hashCode());
        assertEquals(initialHashcode, add.hashCode());
    }

    @Test
    public void should_have_same_hashcode_for_equal_objects() {
        Operator add = new Operator(1, "+", new Add());
        Operator plus = new Operator(1, "+", new Add());
        assertEquals(add.hashCode(), plus.hashCode());
    }

    @Test
    public void should_have_different_hashcode_for_non_equal_objects() {
        Operator add = new Operator(0, "+", new Add());
        Operator multiply = new Operator(1, "*", new Multiply());
        assertTrue(add.hashCode() != multiply.hashCode());
    }

}