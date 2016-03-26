package com.eca.nlp.kb.validator;

import com.eca.nlp.kb.exception.UnknownLexicon;
import org.junit.Test;

public class LengthRuleTest {

    private ExpressionRule sut = new LengthRule();

    @Test
    public void validate_even_elements() throws Exception {
        sut.validate(new String[]{"1", "+", "3"});
    }

    @Test(expected = UnknownLexicon.class)
    public void validate_odd_elements() throws Exception {
        sut.validate(new String[]{"1", "+", "2", "+"});
    }

    @Test
    public void validate_one_elements() throws Exception {
        sut.validate(new String[]{"one",});
    }

    @Test(expected = UnknownLexicon.class)
    public void validate_two_elements() throws Exception {
        sut.validate(new String[]{"1", "+"});
    }
}