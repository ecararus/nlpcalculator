package com.eca.nlp.kb.transformer;

import com.eca.nlp.kb.exception.UnknownOperator;
import com.eca.nlp.kb.model.Operator;

import java.util.function.Predicate;

import static com.eca.nlp.kb.Lexicon.operators;

final class OperationTransformer implements LexicalTransformer {

    @SuppressWarnings("unchecked")
    @Override
    public String toArithmetical(String human) {
        Operator operator = operators().stream().filter(humanLexiconFilter(human)).findAny().orElseThrow(() -> new UnknownOperator(human));
        return operator.getArithmetical();
    }

    private Predicate<Operator> humanLexiconFilter(String human) {
        return s -> s.getHuman().stream().anyMatch(p -> p.equalsIgnoreCase(human));
    }
}


