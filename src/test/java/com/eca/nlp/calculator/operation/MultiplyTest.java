package com.eca.nlp.calculator.operation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyTest {

    private ArithmeticEvaluator sut = new Multiply();

    @Test
    public void should_support_double() throws Exception {
        Assert.assertEquals(6.28D,sut.evaluate(3.14D,2D));
    }

    @Test
    public void should_support_left_double() throws Exception {
        Assert.assertEquals(3.14D,sut.evaluate(3.14D,1));
    }

    @Test
    public void should_support_right_double() throws Exception {
        Assert.assertEquals(6.28D,sut.evaluate(2,3.14D));
    }

    @Test
    public void should_support_int() throws Exception {
        Assert.assertEquals(10,sut.evaluate(5,2));
    }

}