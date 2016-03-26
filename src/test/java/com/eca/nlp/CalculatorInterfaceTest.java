package com.eca.nlp;

import com.eca.nlp.kb.LexicalConverter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorInterfaceTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void not_instantiable() throws Exception {
        thrown.expectCause(instanceOf(UnsupportedOperationException.class));
        Constructor<CalculatorInterface> constructor = CalculatorInterface.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void number_format_should_be_without_dot_for_integer() throws Exception {
        assertEquals("6", CalculatorInterface.calculate ("one add five"));
    }

    @Test
    public void number_format_should_be_with_two_digets_after_dot() throws Exception {
        assertEquals("0.33", CalculatorInterface.calculate ("one OVER three"));
    }
}