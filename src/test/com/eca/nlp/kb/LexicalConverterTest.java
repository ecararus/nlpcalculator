package com.eca.nlp.kb;

import com.eca.nlp.kb.exception.UnknownLexicon;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertTrue;

public class LexicalConverterTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void not_instantiable() throws Exception {
        thrown.expectCause(instanceOf(UnsupportedOperationException.class));
        Constructor<LexicalConverter> constructor = LexicalConverter.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void cant_transform_invalid_expression() {
        thrown.expect(UnknownLexicon.class);
        LexicalConverter.toArithmeticalExpression("THIS EXPRESSION IS INVALID !");
    }

    @Test
    public void transform_complex_expression() {
        Assert.assertEquals("1+2/3/5+4-6-7*8*9", LexicalConverter.toArithmeticalExpression("one add two over three DIVIDE-BY five PLUS four Minus six less seVEN multiply-by Eight times nine"));
    }

    @Test
    public void not_instantiable_lexicon() throws Exception {
        thrown.expectCause(instanceOf(UnsupportedOperationException.class));
        Constructor<Lexicon> constructor = Lexicon.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}