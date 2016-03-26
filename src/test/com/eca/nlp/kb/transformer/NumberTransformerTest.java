package com.eca.nlp.kb.transformer;

import com.eca.nlp.kb.exception.UnknownNumber;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class NumberTransformerTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private LexicalTransformer sut = new NumberTransformer();

    @Test
    public void can_not_transform_unknown_number() throws Exception {
        thrown.expect(UnknownNumber.class);
        thrown.expectMessage("NOT_A_NUMBER");
        sut.toArithmetical("NOT_A_NUMBER");
    }

    @Test
    public void transform_one() throws Exception {
        assertEquals("1", sut.toArithmetical("one"));
    }

    @Test
    public void transform_not_key_sensitive() throws Exception {
        assertEquals("3", sut.toArithmetical("THREE"));
    }

}