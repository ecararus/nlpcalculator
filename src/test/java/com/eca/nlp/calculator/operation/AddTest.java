package com.eca.nlp.calculator.operation;

import org.junit.Assert;
import org.junit.Test;

public class AddTest {
    private ArithmeticEvaluator sut = new Add();

    @Test
    public void should_support_double() throws Exception {
        Assert.assertEquals(3.2800000000000002D, sut.evaluate(3.14D, 0.14D));
    }

    @Test
    public void should_support_left_double() throws Exception {
        Assert.assertEquals(4.140000000000001D, sut.evaluate(3.14D, 1));
    }

    @Test
    public void should_support_right_double() throws Exception {
        Assert.assertEquals(4.140000000000001, sut.evaluate(1, 3.14D));
    }

    @Test
    public void should_support_int() throws Exception {
        Assert.assertEquals(7, sut.evaluate(5, 2));
    }
}