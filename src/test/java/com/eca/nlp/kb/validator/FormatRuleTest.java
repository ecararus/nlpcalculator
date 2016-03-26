package com.eca.nlp.kb.validator;

import com.eca.nlp.kb.exception.UnknownLexicon;
import org.junit.Test;

public class FormatRuleTest {

    private ExpressionRule sut = new FormatRule();

    @Test(expected = UnknownLexicon.class)
    public void first_element_not_number() throws Exception {
        sut.validate(new String[]{"not_number"});
    }

    @Test(expected = UnknownLexicon.class)
    public void first_element_operator() throws Exception {
        sut.validate(new String[]{"plus"});
    }

    @Test
    public void only_one_element_number() throws Exception {
        sut.validate(new String[]{"nine"});
    }

    @Test(expected = UnknownLexicon.class)
    public void first_element_number_last_not_number() throws Exception {
        sut.validate(new String[]{"two", "not_number"});
    }

    @Test
    public void first_element_number_last_number() throws Exception {
        sut.validate(new String[]{"three", "four"});
    }

    @Test
    public void first_element_uppercase_number_last_lowercase_number() throws Exception {
        sut.validate(new String[]{"FIVE", "six"});
    }

    @Test
    public void first_element_uppercase_number_last_upperrcase_number() throws Exception {
        sut.validate(new String[]{"SEVEN", "EIGHT"});
    }
}