package com.eca.nlp.kb.model;

import org.junit.Test;

import java.util.HashSet;

import static java.util.Collections.EMPTY_SET;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;
import static org.junit.Assert.*;

public class OperatorTest {

    @Test(expected = NullPointerException.class)
    public void instantiate_with_null_arithmetical() throws Exception {
        new Operator(null, new HashSet<>());
    }

    @Test(expected = NullPointerException.class)
    public void instantiate_with_null_human() throws Exception {
        new Operator("+", null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void mutate_human() throws Exception {
        Operator operator = new Operator("+", new HashSet<>());
        operator.getHuman().add("new");
    }

    @Test
    public void same_instance_should_be_equal() throws Exception {
        Operator operator = new Operator("+", new HashSet<>());
        assertTrue(operator.equals(operator));
    }

    @Test
    public void could_not_be_equal_with_null() throws Exception {
        Operator operator = new Operator("+", new HashSet<>());
        assertFalse(operator.equals(null));
    }

    @Test
    public void could_not_be_equal_with_different_instance() throws Exception {
        Operator operator = new Operator("+", new HashSet<>());
        assertFalse(operator.equals(new String()));
    }

    @Test
    public void could_not_be_equal_when_arithmetical_is_different() throws Exception {
        Operator operatorPlus = new Operator("+", new HashSet<>());
        Operator operatorMinus = new Operator("-", new HashSet<>());
        assertFalse(operatorPlus.equals(operatorMinus));
    }

    @Test
    public void could_not_be_equal_when_human_is_different() throws Exception {
        Operator operatorPlus = new Operator("+", of("one").collect(toSet()));
        Operator operatorAdd = new Operator("+", of("another").collect(toSet()));
        assertFalse(operatorPlus.equals(operatorAdd));
    }

    @Test
    public void should_be_equal_when_params_is_the_same() throws Exception {
        Operator operatorPlus = new Operator("+", of("one").collect(toSet()));
        Operator operatorAdd = new Operator("+", of("one").collect(toSet()));
        assertTrue(operatorPlus.equals(operatorAdd));
    }

    @Test
    public void hashcode_should_Be_Consistent() {
        Operator operatorPlus = new Operator("+", of("one").collect(toSet()));
        int initialHashcode = operatorPlus.hashCode();
        assertEquals(initialHashcode, operatorPlus.hashCode());
        assertEquals(initialHashcode, operatorPlus.hashCode());
    }

    @Test
    public void should_have_same_hashcode_for_equal_objects() {
        Operator operatorPlus = new Operator("+", of("one").collect(toSet()));
        Operator operatorAdd = new Operator("+", of("one").collect(toSet()));
        assertEquals(operatorPlus.hashCode(), operatorAdd.hashCode());
    }

    @Test
    public void should_have_different_hashcode_for_non_equal_objects() {
        Operator operatorPlus = new Operator("+", EMPTY_SET);
        Operator operatorMinus = new Operator("-", EMPTY_SET);
        assertTrue(operatorPlus.hashCode() != operatorMinus.hashCode());
    }
}