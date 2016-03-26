package com.eca.nlp.kb;

import com.eca.nlp.kb.transformer.ExpressionTransformer;
import com.eca.nlp.kb.transformer.LexicalTransformer;

import static com.eca.nlp.kb.validator.ExpressionValidator.validate;

public final class LexicalConverter {

    private LexicalConverter() {
        throw new UnsupportedOperationException();
    }

    public static String toArithmeticalExpression(String humanExpression) {
        validate(humanExpression);
        LexicalTransformer facade = new ExpressionTransformer();
        return facade.toArithmetical(humanExpression);
    }

}
