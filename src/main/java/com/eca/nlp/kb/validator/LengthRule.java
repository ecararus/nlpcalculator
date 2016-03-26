package com.eca.nlp.kb.validator;

import com.eca.nlp.kb.exception.UnknownLexicon;

final class LengthRule implements ExpressionRule {

    @Override
    public void validate(String[] expressionElements) {
        int length = expressionElements.length;
        if (length % 2 == 0 || length == 2) {
            throw new UnknownLexicon();
        }
    }
}