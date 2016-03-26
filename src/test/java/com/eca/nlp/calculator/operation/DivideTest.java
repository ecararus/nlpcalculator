package com.eca.nlp.calculator.operation;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DivideTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private ArithmeticEvaluator sut = new Divide();

    @Test
    public void should_support_double() throws Exception {
        Assert.assertEquals(2.8181818181818183D,sut.evaluate(9.3D,3.3D));
    }

    @Test
    public void should_support_left_double() throws Exception {
        Assert.assertEquals(3.14D,sut.evaluate(3.14D,1));
    }

    @Test
    public void should_support_right_double() throws Exception {
        Assert.assertEquals(0.3184713375796178D,sut.evaluate(1,3.14D));
    }

    @Test
    public void should_support_int() throws Exception {
        Assert.assertEquals(2.5,sut.evaluate(5,2));
    }

    @Test
    public void should_not_support_division_by_zero() throws Exception {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Division by 0");
        Assert.assertEquals(2.5,sut.evaluate(5,0));
    }

}