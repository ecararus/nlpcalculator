package com.eca.nlp.calculator.operation;

import org.junit.Assert;
import org.junit.Test;

public class SubtractTest {

    private ArithmeticEvaluator sut = new Subtract();

    @Test
    public void should_support_double() throws Exception {
        Assert.assertEquals(3.0D, sut.evaluate(3.14D, 0.14D));
    }

    @Test
    public void should_support_left_double() throws Exception {
        Assert.assertEquals(2.14D, sut.evaluate(3.14D, 1));
    }

    @Test
    public void should_support_right_double() throws Exception {
        Assert.assertEquals(-2.14D, sut.evaluate(1, 3.14D));
    }

    @Test
    public void should_support_int() throws Exception {
        Assert.assertEquals(3, sut.evaluate(5, 2));
    }
}