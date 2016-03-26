package com.eca.nlp.kb.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTest {

    @Test(expected = NullPointerException.class)
    public void instantiate_with_null_arithmetical() throws Exception {
        new Number(null, "/");
    }

    @Test(expected = NullPointerException.class)
    public void instantiate_with_null_human() throws Exception {
        new Number(null, "/");
    }

    @Test
    public void same_instance_should_be_equal() throws Exception {
        Number number = new Number("1", "one");
        assertTrue(number.equals(number));
    }

    @Test
    public void could_not_be_equal_with_null() throws Exception {
        Number number = new Number("1", "one");
        assertFalse(number.equals(null));
    }

    @Test
    public void could_not_be_equal_with_different_instance() throws Exception {
        Number number = new Number("1", "one");
        assertFalse(number.equals(new String()));
    }

    @Test
    public void could_not_be_equal_when_arithmetical_is_different() throws Exception {
        Number numberOne = new Number("1", "one");
        Number numberTwo = new Number("2", "one");
        assertFalse(numberOne.equals(numberTwo));
    }

    @Test
    public void could_not_be_equal_when_human_is_different() throws Exception {
        Number numberOne = new Number("1", "one");
        Number numberFirst = new Number("1", "first");
        assertFalse(numberOne.equals(numberFirst));
    }

    @Test
    public void should_be_equal_when_params_is_the_same() throws Exception {
        Number numberOne = new Number("1", "one");
        Number first = new Number("1", "one");
        assertTrue(numberOne.equals(first));
    }

    @Test
    public void hashcode_should_Be_Consistent() {
        Number numberOne = new Number("1", "one");
        int initialHashcode = numberOne.hashCode();
        assertEquals(initialHashcode, numberOne.hashCode());
        assertEquals(initialHashcode, numberOne.hashCode());
    }

    @Test
    public void should_have_same_hashcode_for_equal_objects() {
        Number numberOne = new Number("1", "one");
        Number first = new Number("1", "one");
        assertEquals(numberOne.hashCode(), first.hashCode());
    }

    @Test
    public void should_have_different_hashcode_for_non_equal_objects() {
        Number numberOne = new Number("1", "one");
        Number numberFirst = new Number("1", "first");
        assertTrue(numberOne.hashCode() != numberFirst.hashCode());
    }

}