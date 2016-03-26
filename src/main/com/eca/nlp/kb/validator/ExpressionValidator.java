package com.eca.nlp.kb.validator;

import com.eca.nlp.kb.exception.UnknownLexicon;

import java.util.Collection;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableCollection;
import static java.util.Objects.requireNonNull;

public final class ExpressionValidator {

    public static final Collection<ExpressionRule> RULES = unmodifiableCollection(asList(new LengthRule(), new FormatRule()));

    private ExpressionValidator() {
        throw new UnsupportedOperationException();
    }

    public static void validate(String expression) {
        requireNonNull(expression);
        String[] expressionElements = expression.split("\\s+");
        requireNonEmpty(expressionElements);
        RULES.forEach(c -> c.validate(expressionElements));
    }

    private static void requireNonEmpty(String[] expressionElements) {
        if (expressionElements.length == 0) {
            throw new UnknownLexicon();
        }
    }
}
