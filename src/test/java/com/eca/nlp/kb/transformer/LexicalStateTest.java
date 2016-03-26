package com.eca.nlp.kb.transformer;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static com.eca.nlp.kb.transformer.LexicalState.nextState;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LexicalStateTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void not_instantiable() throws Exception {
        thrown.expectCause(instanceOf(UnsupportedOperationException.class));
        Constructor<LexicalState> constructor = LexicalState.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void default_transformer_should_be_number() throws Exception {
        assertThat(nextState(null).getClass(), sameInstance(NumberTransformer.class));
    }

    @Test
    public void next_step_after_number_should_be_operator() throws Exception {
        assertThat(nextState(new NumberTransformer()).getClass(), sameInstance(OperationTransformer.class));
    }

    @Test
    public void next_step_after_operator_should_be_number() throws Exception {
        assertThat(nextState(new OperationTransformer()).getClass(), sameInstance(NumberTransformer.class));
    }
}