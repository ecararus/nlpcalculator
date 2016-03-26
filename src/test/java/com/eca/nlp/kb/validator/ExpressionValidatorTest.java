package com.eca.nlp.kb.validator;

import com.eca.nlp.kb.exception.UnknownLexicon;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertTrue;

public class ExpressionValidatorTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test(expected = NullPointerException.class)
    public void given_expression_is_null() throws Exception {
        ExpressionValidator.validate(null);
    }

    @Test(expected = UnknownLexicon.class)
    public void given_expression_is_empty() throws Exception {
        ExpressionValidator.validate("");
    }

    @Test(expected = UnknownLexicon.class)
    public void given_expression_contains_only_spaces() throws Exception {
        ExpressionValidator.validate("            ");
    }

    @Test(expected = UnknownLexicon.class)
    public void given_expression_contains_spaces_and_valid_number() throws Exception {
        ExpressionValidator.validate("  one     plus   two  ");
    }

    @Test
    public void given_expression_has_valid_format() throws Exception {
        ExpressionValidator.validate("one plus two");
    }

    @Test
    public void not_instantiable() throws Exception {
        thrown.expectCause(instanceOf(UnsupportedOperationException.class));
        Constructor<ExpressionValidator> constructor = ExpressionValidator.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}