package com.eca.nlp.kb.validator;

import com.eca.nlp.kb.exception.UnknownLexicon;

import static com.eca.nlp.kb.Lexicon.numbers;

final class FormatRule implements ExpressionRule {

    public void validate(String[] expressionElements) {
        isNumber(expressionElements[0]);
        isNumber(expressionElements[expressionElements.length - 1]);
    }

    private void isNumber(String item) {
        if (!numbers().stream().anyMatch(s -> s.getHuman().equalsIgnoreCase(item))) {
            throw new UnknownLexicon();
        }
    }
}
