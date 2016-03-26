package com.eca.nlp.calculator.impl;

import com.eca.nlp.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class BasicCalculatorTest {

    private Calculator<String> sut = new BasicCalculator();

    @Test
    public void calculate_one_number(){
        Assert.assertEquals(new Integer(3), sut.calculate("3"));
    }

    @Test
    public void calculate_simple_expression(){
        Assert.assertEquals(new Integer(5), sut.calculate("3+2"));
    }

    @Test
    public void calculate_simple_expression_with_different_operator_priority(){
        Assert.assertEquals(new Integer(9), sut.calculate("3+2*3"));
    }

    @Test
    public void calculate_simple_expression_with_all_operator(){
        Assert.assertEquals(new Double(7.4), sut.calculate("3+2*3-3/5-1"));
    }

    @Test
    public void calculate_simple_expression_with_series_of_operator(){
        Assert.assertEquals(new Double(-18.99999999999999), sut.calculate("3+2+3-3-5*4*2/5/4/2/1-4-5+6+7/3"));
    }
}