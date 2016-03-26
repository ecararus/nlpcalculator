package com.eca.nlp.calculator.impl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertTrue;

public class CalculatorProviderTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void not_instantiable() throws Exception {
        thrown.expectCause(instanceOf(UnsupportedOperationException.class));
        Constructor<CalculatorProvider> constructor = CalculatorProvider.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void should_load_basic_calculator() throws Exception {
        Assert.assertThat(CalculatorProvider.loadBasicCalculator().getClass(), sameInstance(BasicCalculator.class));
    }

}