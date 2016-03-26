package com.eca.nlp.kb.transformer;

import com.eca.nlp.kb.exception.UnknownOperator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class OperationTransformerTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private LexicalTransformer sut = new OperationTransformer();

    @Test
    public void can_not_transform_unknown_operator() throws Exception {
        thrown.expect(UnknownOperator.class);
        thrown.expectMessage("NOT_AN_OPERATOR");
        sut.toArithmetical("NOT_AN_OPERATOR");
    }

    @Test
    public void transform_multiply_by() throws Exception {
        assertEquals("*", sut.toArithmetical("multiply-by"));
    }

    @Test
    public void transform_not_key_sensitive() throws Exception {
        assertEquals("/", sut.toArithmetical("OVER"));
    }
}