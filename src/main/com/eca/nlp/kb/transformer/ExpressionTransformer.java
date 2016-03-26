package com.eca.nlp.kb.transformer;

import static com.eca.nlp.kb.transformer.LexicalState.nextState;

/**
 * Facade of all transformers.
 */
public final class ExpressionTransformer implements LexicalTransformer {

    @SuppressWarnings("unchecked")
    public String toArithmetical(String humanExpression) {
        String[] expressionElements = humanExpression.split("\\s+");
        replaceHumanExpression(expressionElements, 0, null);
        return String.join("", expressionElements);
    }

    private void replaceHumanExpression(String[] expressionElements, int position, LexicalTransformer context) {
        if (position == expressionElements.length) {
            return;
        }
        context = nextState(context);
        transformElement(expressionElements, position, context);
        replaceHumanExpression(expressionElements, ++position, context);
    }

    private void transformElement(String[] expressionElements, int position, LexicalTransformer context) {
        expressionElements[position] = context.toArithmetical(expressionElements[position]);
    }
}
