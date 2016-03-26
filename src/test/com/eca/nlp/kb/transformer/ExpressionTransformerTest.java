package com.eca.nlp.kb.transformer;

import com.eca.nlp.kb.exception.UnknownLexicon;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionTransformerTest {

    private LexicalTransformer sut = new ExpressionTransformer();

    @Test(expected = UnknownLexicon.class)
    public void transform_one_invalid_expression() {
        sut.toArithmetical("multiply five");
    }

    @Test
    public void transform_one_element_expression() {
        Assert.assertEquals("5", sut.toArithmetical("five"));
    }

    @Test
    public void transform_complex_expression() {
        Assert.assertEquals("1+2/3/5+4-6-7*8*9", sut.toArithmetical("one add two over three DIVIDE-BY five PLUS four Minus six less seVEN multiply-by Eight times nine"));
    }
}